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
    private int asistencia;

    private boolean deuce;
    private boolean tieBreak;
    private boolean time;
    private int setJ1 = 0;
    private int setJ2 = 0;
    private int nSet = 0;
    private int acumulador1 = 0;
    private int acumulador2 = 0;

    /**
     *
     * @param id
     * @param jugador1
     * @param jugador2
     * @param pista
     */
    public Partido(String id, Jugador jugador1, Jugador jugador2, Pista pista) {
        this.tiempo = "00:00:00";
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.pista = pista;
        this.fechaHora = fechaHoraAleatoria();
        this.asistencia = generarAsistenciaAleatoria();
        this.deuce = false;
        this.tieBreak = false;
        this.sets = new String[2][6];
        inicializarSets();

    }

    /**
     *
     * @return
     */
    public int generarAsistenciaAleatoria() {
        Random aleatorio = new Random();
        int capacidad = pista.getCapacidadMax();
        int res = aleatorio.nextInt(capacidad);
        return res;
    }

    /**
     *
     * @return
     */
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

    /**
     *Metodo para jugar manualmente el partido
     */
    public void jugar() {
        boolean ganador = determinarGanador();                  // Se consulta si ya hay un ganador en este partido.
        boolean punto = false;                                  // variable que indica cual jugador gana el siguiente punto del game.
        boolean gameGanado = false;                             // Variable que indica si ya se gano el game en juego.
        boolean setGanado = false;                              // Variable que indica si ya se gano el set en juego.

        int j1 = (Integer.parseInt(sets[0][nSet]));             // games ganados en el set en juego del jugador 1.
        int j2 = (Integer.parseInt(sets[1][nSet]));             // games ganados en el set en juego del jugador 2.
        int n = 0;                                              // Variable para determinar en el metodo en que se gana un game ya sea en tibreak o un game normal.

        if (ganador == false) {                                 // Si no hay ganador en el partido se procede a jugar un nuevo punto.
            punto = generarPuntos();                            // Se genera un boolean aleatorio para determinar quien gana el siguiente punto en el game
            if (punto == true) {                                // Si punto es treu, el punto se le suma al jugador 1.
                acumulador1++;
            } else {                                            // De lo contrario se le suma el punto al jugador 2.
                acumulador2++;
            }
            if ((nSet < 4) && (j1 == j2) && (j1 == 6)) {        // Sí el jugador se han juegado menos de 5 sets, y ambos jugadores tiene seis games ganados, se procede a sumar el siguiente punto con la regla del tiebreak.
                sumarTiebreak(punto);                           // Se llama al metodo para sumar el punto en la matriz de la forma  tiebrak
                n = 5;                                  
            } else {                                            // De lo contrario se procede a sumar en punto como un game normal.
                sumarPunto(acumulador1, acumulador2, punto);    // Se llama al metodo para sumar el punto en la matriz de la forma normal.
                n = 3;
            }
            gameGanado = determinarGanadorGame(acumulador1, acumulador2, n, punto); // Se llama al metodo para saber si ya se gano el game o tiebrak en juego.
            if (gameGanado == true) {                                               // Sí ya se gano el game o tiebreak.
                if (punto == true) {                                                // Sí lo gano el jugador 1.
                    sets[0][nSet] = ((Integer.parseInt(sets[0][nSet])) + 1) + "";   // Se aumenta un game en el set en juego en la posicion del set del jugador 1.
                } else {                                                            // De lo contrario:
                    sets[1][nSet] = ((Integer.parseInt(sets[1][nSet])) + 1) + "";   // Se aumenta un game en el set en juego en la posicion del set del jugador 2.
                }
                sets[0][5] = "0";                                                   // Se reician los acumuladores de los puntos de ambos jugadores.
                sets[1][5] = "0";

                acumulador1 = 0;
                acumulador2 = 0;

                j1 = (Integer.parseInt(sets[0][nSet]));          // Games ganados en el set en juego del jugador 1.                   
                j2 = (Integer.parseInt(sets[1][nSet]));          // Games ganados en el set en juego del jugador 2.
                if ((j1 == j2) && (j1 == 6) && (nSet < 4)) {     // Sí se esta jugando del 1 al 4 set y los puntos de ambos jugadores son de 6 Games.
                    this.setTieBreak(true);                      // Se pone en true la bandera del tieBreak para mostrar en mensaje en la interfaz.
                } else {                                         // De lo contratio:
                    this.setTieBreak(false);                     // Se pone en false la bandera del tiBreak.
                }

                setGanado = determinarGanadorSet(n);             // Se llama al metodo para determinar sí ya hay ganador del set en juego.
                if (setGanado == true) {                         // Sí ya se gano el set.
                    nSet++;                                      // Se incrementa la variable de los sets jugados.
                    if (punto == true) {                         // Sí el set lo gano el jugador 1
                        setJ1++;                                 // Se aumenta la variable de los sets ganados del jugador 1.
                    } else {                                     // De lo contrario:
                        setJ2++;                                 // Se aumenta la variable de los sets ganados del jugador 2.
                    }
                }
            }
        } else {
            time = true;
        }
    }

    /**
     *
     */
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
        sets[0][5] = "0";
        sets[1][5] = "0";
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

    /**
     *
     * @return
     */
    public boolean determinarGanador() {
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
        if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1))) || ((j1 == 7) || (j2 == 7) && (nSet < 4))) {
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
                        setJ1++;
                    } else {
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

    /**
     *
     * @return
     */
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
                    if (sets[1][5].equals("40")) {
                        this.setDeuce(true);
                    } else {
                        this.setDeuce(false);
                    }
                    break;

                default:
                    if (comparador1 == comparador2) {
                        sets[0][5] = "40";
                        sets[1][5] = "40";
                        this.setDeuce(true);
                    } else {
                        sets[0][5] = "AD";
                        sets[1][5] = "-";
                        this.setDeuce(false);
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
                    if (sets[0][5].equals("40")) {
                        this.setDeuce(true);
                    } else {
                        this.setDeuce(false);
                    }
                    break;

                default:
                    if (comparador2 == comparador1) {
                        sets[0][5] = "40";
                        sets[1][5] = "40";
                        this.setDeuce(true);
                    } else {
                        sets[0][5] = "-";
                        sets[1][5] = "AD";
                        this.setDeuce(false);
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
        this.setTieBreak(false);
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
        if (time == false) {
            int hora, minuto, segundo;
            String tiempo1, min, seg;
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
            tiempo1 = ("0" + hora + ":" + min + ":" + seg);
            setTiempo(tiempo1);
            time = true;
        }
    }

    /**
     *
     */
    public void inicializarSets() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                sets[i][j] = "0";
            }
        }
    }

    /**
     *
     * @return
     */
    public Jugador getJugador1() {
        return jugador1;
    }

    /**
     *
     * @param jugador1
     */
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     *
     * @return
     */
    public Jugador getJugador2() {
        return jugador2;
    }

    /**
     *
     * @param jugador2
     */
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    /**
     *
     * @return
     */
    public Pista getPista() {
        return pista;
    }

    /**
     *
     * @param pista
     */
    public void setPista(Pista pista) {
        this.pista = pista;
    }

    /**
     *
     * @return
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     *
     * @param fechaHora
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String[][] getSets() {
        return sets;
    }

    /**
     *
     * @param sets
     */
    public void setSets(String[][] sets) {
        this.sets = sets;
    }

    /**
     *
     * @return
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     *
     * @param tiempo
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     *
     * @return
     */
    public boolean getDeuce() {
        return deuce;
    }

    /**
     *
     * @param deuce
     */
    public void setDeuce(boolean deuce) {
        this.deuce = deuce;
    }

    /**
     *
     * @return
     */
    public boolean getTieBreak() {
        return tieBreak;
    }

    /**
     *
     * @param tieBreak
     */
    public void setTieBreak(boolean tieBreak) {
        this.tieBreak = tieBreak;
    }

    /**
     *
     * @param asistencia
     */
    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    /**
     *
     * @return
     */
    public int getAsistencia() {
        return asistencia;
    }
}
