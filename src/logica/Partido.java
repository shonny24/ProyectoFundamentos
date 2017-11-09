/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Shonny
 */
public class Partido {

    private String id;
    private Jugador jugador1;
    private Jugador jugador2;
    private Pista pista;
    private String tiempo;
    private String fechaHora;
    private String sets[][];

    private int setJ1 = 0;
    private int setJ2 = 0;
    private int nSet = 0;
    private int acumulador1 = 0;
    private int acumulador2 = 0;

    public Partido(String id, Jugador jugador1, Jugador jugador2, Pista pista) {
        this.tiempo = "00:00:00:00";
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.pista = pista;
//        this.estadistica = estadistica;
        this.fechaHora = fechaHoraAleatoria();
        this.sets = new String[2][6];
        inicializarSets();

    }

    public String fechaHoraAleatoria() {
        Calendar unaFecha = Calendar.getInstance();
        Random aleatorio = new Random();

//        Expresión                         Distancia
//        generator.nextInt(100)            0 a 99
//        generator.nextInt(256)            0 a 255
//        generator.nextInt(6) + 1          1 a 6
//        generator.nextInt(20) + 100       100 a 119
//        generator.nextInt(50) - 10        -10 a 39
//        generator.nextInt(10) - 50        -50 a -41
//
//         Un valor long
//        sr.nextLong();
//         Un valor int
//        sr.nextInt();
//         Un valor float
//        sr.nextFloat();
//         Un valor double
//        sr.nextDouble();
//         Un valor gaussian (entre -1 y 1))
//        sr.nextGaussian();
//         Un valor boolean, como lanzar una moneda
//        sr.nextBoolean();
//         ... y un valor int entre 0 (inclusivo) y int n (exclusivo)
//        sr.nextInt(n);
//         Así para tener un valor entero aleatorio de 1 al 10, se usa
//        sr.nextInt(10)+1;
//
//            kk = Hours in 1-24 format
//            hh= hours in 1-12 format
//            KK= hours in 0-11 format
//            HH= hours in 0-23 format
//
//            Año
//
//            "yy" -> "03″
//
//            "yyyy" -> "2003″
//
//            Mes
//
//            "M" -> "7″
//
//            "M" -> "12″
//
//            "MM" -> "07″
//
//            "MMM" -> "Jul"
//
//            "MMMM" -> "Deciembre"
//
//            Día del mes
//
//            "d" -> "3″
//
//            "dd" -> "03″
//
        unaFecha.set(2017, aleatorio.nextInt(3) + 9, aleatorio.nextInt(30) + 1, aleatorio.nextInt(24) + 1, aleatorio.nextInt(60));
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa -- dd/MMMMM/yyyy");
        String fechaHora = sdf.format(unaFecha.getTime());

        return fechaHora;
    }

    public void jugar() {
        boolean ganador = determinarGanador();
        boolean punto = false;
        boolean gameGanado = false;
        boolean setGanado = false;

        int j1 = (Integer.parseInt(sets[0][nSet]));
        int j2 = (Integer.parseInt(sets[1][nSet]));
        int n = 0;

        if (ganador == false) {
            punto = generarPuntos();
            if (punto == true) {
                acumulador1++;
            } else {
                acumulador2++;
            }
            if ((nSet < 4) && (j1 == j2) && (j1 == 6)) {
                sumarTiebreak(punto);
                n = 5;
            } else {
                sumarPunto(acumulador1, acumulador2, punto);
                n = 3;
            }
            gameGanado = determinarGanadorGame(acumulador1, acumulador2, n, punto);
            if (gameGanado == true) {
                if (punto == true) {
                    sets[0][nSet] = ((Integer.parseInt(sets[0][nSet])) + 1) + "";
                } else {
                    sets[1][nSet] = ((Integer.parseInt(sets[1][nSet])) + 1) + "";
                }
                sets[0][5] = "0";
                sets[1][5] = "0";

                acumulador1 = 0;
                acumulador2 = 0;

                setGanado = determinarGanadorSet(n);
                if (setGanado == true) {
                    nSet++;
                    if (punto == true) {
                        setJ1++;
                    } else {
                        setJ2++;
                    }
                }
            }
        }
    }

    public void inicializarSets() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                sets[i][j] = "0";
            }
        }
    }

    public void generarJuegoAutomatico() {
        boolean ganador;
        ganador = determinarGanador();
        for (int i = 0; i < 5; i++) {
            if (ganador == false) {
                jugarSet(i);
            } else {
                i = 5;
            }
            ganador = determinarGanador();
        }
        sets[0][5] = "";
        sets[1][5] = "";
        generarTiempoPartido();
    }

    private boolean jugarGame() {//Se ejecuta el metodo generaGame el cual retorna un boolean para saber quien gano ese game.
        boolean punto = false;
        boolean ganarPunto = false;
        int comparador1 = 0;
        int comparador2 = 0;
        while (ganarPunto == false) {
            if (((comparador1 > 3) && (comparador2 < (comparador1 - 1))) || ((comparador2 > 3) && (comparador1 < (comparador2 - 1)))) {
                ganarPunto = true;
            } else {
                punto = generarPuntos();
                if (punto == true) {
                    comparador1++;
                } else {
                    comparador2++;
                }
                sumarPunto(comparador1, comparador2, punto);
            }
        }
        return punto;
    }

    private boolean determinarGanador() {
        boolean ganador = false;
        if (setJ1 >= 3) {
            ganador = true;
        }
        if (setJ2 >= 3) {
            ganador = true;
        }
        return ganador;
    }

    private void jugarSet(int set) {
        boolean ganadorSet = false;
        boolean game;
        boolean ganadorTieBreak = false;
        int j1 = (Integer.parseInt(sets[0][set]));
        int j2 = (Integer.parseInt(sets[1][set]));
        if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1)))) {
            ganadorSet = true;
        }
        while (ganadorSet == false) {
            if ((j1 == j2) && ((j1 == 6) && (j2 == 6))) {
                if (set == 4) {
                    jugarDobleGame();
                    ganadorSet = true;
                } else {
                    ganadorTieBreak = jugarTieBreak(set);
                    ganadorSet = true;
                    if (ganadorTieBreak == true) {
                        //sets[0][set] = ((Integer.parseInt(sets[0][set])) + 1) + "";
                        setJ1++;
                    } else {
                        //sets[1][set] = ((Integer.parseInt(sets[1][set])) + 1) + "";
                        setJ2++;
                    }
                }
            } else {
                game = jugarGame();
                if (game == true) {
                    sets[0][set] = ((Integer.parseInt(sets[0][set])) + 1) + "";
                } else {
                    sets[1][set] = ((Integer.parseInt(sets[1][set])) + 1) + "";
                }
            }
            j1 = (Integer.parseInt(sets[0][set]));
            j2 = (Integer.parseInt(sets[1][set]));
            if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1)))) {
                ganadorSet = true;
                if (j1 > j2) {
                    setJ1++;
                } else {
                    setJ2++;
                }
            }
        }
    }

    private boolean jugarTieBreak(int set) {
        sets[0][5] = "0";
        sets[1][5] = "0";
        int j1 = 0;
        int j2 = 0;
        boolean ganarTieBreak = false;
        boolean punto = false;
        while (ganarTieBreak == false) {
            if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1)))) {
                ganarTieBreak = true;
            } else {
                punto = generarPuntos();
                if (punto == true) {
                    sets[0][5] = ((Integer.parseInt(sets[0][5])) + 1) + "";
                } else {
                    sets[1][5] = ((Integer.parseInt(sets[1][5])) + 1) + "";
                }
            }
            j1 = (Integer.parseInt(sets[0][5]));
            j2 = (Integer.parseInt(sets[1][5]));
        }
        if (punto == true) {
            sets[0][set] = "7";
        } else {
            sets[1][set] = "7";
        }
        return punto;
    }

    private boolean jugarDobleGame() {
        int j1 = (Integer.parseInt(sets[0][4]));
        int j2 = (Integer.parseInt(sets[1][4]));
        boolean ganarDobleGame = false;
        boolean game = false;
        while (ganarDobleGame == false) {
            if ((j1 < (j2 - 1)) || (j2 < (j1 - 1))) {
                ganarDobleGame = true;
                if (j1 > j2) {
                    setJ1++;
                } else {
                    setJ2++;
                }
            } else {
                game = jugarGame();
                if (game == true) {
                    sets[0][4] = ((Integer.parseInt(sets[0][4])) + 1) + "";
                } else {
                    sets[1][4] = ((Integer.parseInt(sets[1][4])) + 1) + "";
                }
            }
            j1 = (Integer.parseInt(sets[0][4]));
            j2 = (Integer.parseInt(sets[1][4]));
        }
        if (j1 > j2) {
            game = true;
        } else {
            game = false;
        }
        return game;
    }

    public boolean generarPuntos() {
        Random aleatorio = new Random();
        return aleatorio.nextBoolean();
    }

    private void sumarPunto(int comparador1, int comparador2, boolean punto) {
        if (punto == true) {
            switch (comparador1) {
                case 1:
                    sets[0][5] = "15";
                    break;

                case 2:
                    sets[0][5] = "30";
                    break;

                case 3:
                    sets[0][5] = "40";
                    break;

                default:
                    if (comparador1 == comparador2) {
                        sets[0][5] = "40";
                        sets[1][5] = "40";
                    } else {
                        sets[0][5] = "AD";
                        sets[1][5] = "-";
                    }
                    break;
            }
        } else {
            switch (comparador2) {
                case 1:
                    sets[1][5] = "15";
                    break;

                case 2:
                    sets[1][5] = "30";
                    break;

                case 3:
                    sets[1][5] = "40";
                    break;

                default:
                    if (comparador2 == comparador1) {
                        sets[0][5] = "40";
                        sets[1][5] = "40";
                    } else {
                        sets[0][5] = "-";
                        sets[1][5] = "AD";
                    }
                    break;
            }
        }
    }

    private void sumarTiebreak(boolean punto) {
        if (punto == true) {
            sets[0][5] = ((Integer.parseInt(sets[0][5])) + 1) + "";
        } else {
            sets[1][5] = ((Integer.parseInt(sets[1][5])) + 1) + "";
        }
    }

    private boolean determinarGanadorGame(int acum1, int acum2, int n, boolean punto) {
        boolean ganador = false;
        if (((acum1 > n) && (acum2 < (acum1 - 1))) || ((acum2 > n) && (acum1 < (acum2 - 1)))) {
            ganador = true;
        }
        return ganador;
    }

    private boolean determinarGanadorSet(int n) {
        boolean ganador = false;

        int j1 = (Integer.parseInt(sets[0][nSet]));
        int j2 = (Integer.parseInt(sets[1][nSet]));

        if (n == 5) {
            ganador = true;
        } else {
            if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1)))) {
                ganador = true;
            }
        }
        return ganador;
    }

    private void generarTiempoPartido() {
        int hora, minuto, segundo;
        String tiempo, min, seg;
        Random aleatorio = new Random();
        hora = aleatorio.nextInt(4) + 1;
        minuto = aleatorio.nextInt(59) + 0;
        segundo = aleatorio.nextInt(59) + 0;
        min = (minuto + "");
        seg = (segundo + "");
        if (minuto < 10) {
            min = ("0" + minuto);
        }
        if (segundo < 10) {
            seg = ("0" + segundo);
        }
        tiempo = ("00:0" + hora + ":" + min + ":" + seg);
        setTiempo(tiempo);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[][] getSets() {
        return sets;
    }

    public void setSets(String[][] sets) {
        this.sets = sets;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
