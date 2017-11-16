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

    private String id;//id del partido
    private Jugador jugador1;//jugador 1
    private Jugador jugador2;//jugador 2
    private Pista pista;//pista
    private String tiempo;//Tiempo que dura un partido
    private String fechaHora;//Fecha y hora en que se juega un partido
    private String sets[][];//Sets de cada partido
    private int asistencia;//Asistencia de cada partido

    /**
     *
     */
    public boolean acumulador = false;
    private boolean deuce;
    private boolean tieBreak;
    private boolean time;
    private int setJ1 = 0;
    private int setJ2 = 0;
    private int nSet = 0;
    private int acumulador1 = 0;
    private int acumulador2 = 0;

    /**
     * Constructor
     *
     * @param id
     * @param jugador1
     * @param jugador2
     * @param pista
     */
    public Partido(String id, Jugador jugador1, Jugador jugador2, Pista pista) {
        this.tiempo = "00:00:00"; //Cuando se crea un registro/objeto se inicializa el tiempo en "00:00:00"
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.pista = pista;
        this.fechaHora = fechaHoraAleatoria(); //Cuando se crea un registro/objeto se inicializa con el metodo Fecha y hora aleatoria
        this.asistencia = generarAsistenciaAleatoria(); //Cuando se crea un registro/objeto se inicializa con el metodo generarAsistenciasAleatorias
        this.deuce = false;
        this.tieBreak = false;
        this.sets = new String[2][6];
        inicializarSets(); //Se llama el metodo para inicializar los sets

    }

    /**
     * Metodo que genera aleatoriamente la asistencia dependiendo la campacidad
     * maxima de una pista
     *
     * @return Asistencia por partido
     */
    public int generarAsistenciaAleatoria() {
        Random aleatorio = new Random(); //Clase Random de java
        int capacidad = pista.getCapacidadMax(); //Se obtiene la capacidad maxima de la pista
        int res = aleatorio.nextInt(capacidad); //Se genera un valor aleatorio dependiendo la capacidad de la pista
        return res; //retorna el numero aleatorio
    }

    /**
     * Metodo que genera una fecha y hora aleatoria
     *
     * @return Fecha y hora Aleatoria
     */
    public String fechaHoraAleatoria() {
        Calendar unaFecha = Calendar.getInstance(); //Clase Calendar de java
        Random aleatorio = new Random(); //Clase Random de java

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
        unaFecha.set(2017, aleatorio.nextInt(3) + 9, aleatorio.nextInt(30) + 1, aleatorio.nextInt(24) + 1, aleatorio.nextInt(60));//Generamos la fecha y hora aleatoria
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa -- dd/MMMMM/yyyy");//Damos formato a la fecha y hora
        String fechaHora = sdf.format(unaFecha.getTime()); //obtenemos la fecha y hora ya formateados para pasarlos a un String

        return fechaHora; //retornamos fecha y hora
    }

    /**
     * Metodo para jugar manualmente el partido
     */
    public void jugar() {
        boolean ganador = determinarGanador();                  // Se consulta si ya hay un ganador en este partido.
        boolean punto = false;                                  // variable que indica cual jugador gana el siguiente punto del game.
        boolean gameGanado = false;                             // Variable que indica si ya se gano el game en juego.
        boolean setGanado = false;                              // Variable que indica si ya se gano el set en juego.

        int j1 = (Integer.parseInt(sets[0][nSet]));             // games ganados en el set en juego del jugador 1.
        int j2 = (Integer.parseInt(sets[1][nSet]));             // games ganados en el set en juego del jugador 2.
        int n = 0;                                              // Variable para determinar en el metodo en que se gana un game ya sea en tibreak o un game normal.

        if (ganador == false) {                                 // Sí no hay ganador en el partido se procede a jugar un nuevo punto.
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
        } else {                                                // De lo contrario:
            aculumarTiempo();                                   // Se acumula el tiempo de los 2 jugadores
            acumularPuntos();
            time = true;                                        // Se activa la bandera para detener el cronometro.
        }
    }

    /**
     *
     */
    public void generarJuegoAutomatico() {          // Se ejecuta el metodo para jugar todo el partido de una manera automatica
        boolean ganador;                            // Varible que indica si ya se gano el partido
        ganador = determinarGanador();              // Se llama al metodo para determinar si ya hay ganador del partido
        for (int i = 0; i < 5; i++) {               // Se inicia el recorrido por cada unos de los sets del partido
            if (ganador == false) {                 // Sí no hay ganador del partdido se procede a jugar el set en la posicion i
                jugarSet(i);                        // Se llama al metodo para jugar el set en la posicion i.
            } else {                                // De lo contratio:
                i = 5;                              // Se rompe el ciclo de recorrido por los sets.
            }
            ganador = determinarGanador();          // Se llama al metodo para determinar si ya hay ganador del partido
        }
        sets[0][5] = "0";                           // Se resetea la posicion que lleva los puntos de los games.
        sets[1][5] = "0";                           // Se resetea la posicion que lleva los puntos de los games.
        acumularPuntos();
        generarTiempoPartido();                     // Se llama al metodo par generar el tiempo de duracion del partido
    }

    /**
     *
     * @return
     */
    public boolean jugarGame() {                   //Se ejecuta el metodo generaGame el cual retorna un boolean para saber quien gano el game en juego.
        boolean punto = false;                      //Variable que determina cual de los jugadores gana el punto en juego.
        boolean ganarPunto = false;                 //Variable que determina si ya se gano el game en juego
        int comparador1 = 0;                        //Acumulador de los puntos del jugador 1.
        int comparador2 = 0;                        //Acumulador de los puntos del jugador 2.
        while (ganarPunto == false) {               //Mientras no halla ganador del game.
            if (((comparador1 > 3) && (comparador2 < (comparador1 - 1))) || ((comparador2 > 3) && (comparador1 < (comparador2 - 1)))) {// Condicion para determinar si se gano el game en juego
                ganarPunto = true;                  //Se rompe el ciclo while
            } else {                                //De lo contrario:
                punto = generarPuntos();            // Se genera un nuevo punto.
                if (punto == true) {                // Si punto es true 
                    comparador1++;                  // Se incrementa el acuumulador de puntos del jugador 1.
                } else {                            // De lo contratio:
                    comparador2++;                  // Se incrementa el acuumulador de puntos del jugador 2.
                }
                sumarPunto(comparador1, comparador2, punto);    // Se llama al metodo para sumar los puntos en la matriz.
            }
        }
        return punto; //Retorna el ganador del ultimo punto, que es a su vez el ganador del game.
    }

    /**
     *
     * @return
     */
    public boolean determinarGanador() {    // Metodo que determina si ya hay un ganador del partido
        boolean ganador = false;            // Variable que determina si se gano el partido.
        if (setJ1 >= 3) {                   // Si el jugador 1 gano 3 sets.
            ganador = true;                 // El partido ya termina.
        }
        if (setJ2 >= 3) {                   // Si el jugador 2 gano 3 sets.
            ganador = true;                 // El partido ya termina.
        }
        return ganador;
    }

    /**
     *
     * @param set
     */
    public void jugarSet(int set) {                     // Metodo que ejecuta todo un set.
        boolean ganadorSet = false;                     // Variable que determina si ya se gano el set en juego.
        boolean game;                                   // Variable que determina quien gana el game en juego en el set.
        boolean ganadorTieBreak = false;                // Variable que determina quien gana el tieBreak
        int j1 = (Integer.parseInt(sets[0][set]));      // Variable que contiene los puntos del jugador 1 en el set en juego.
        int j2 = (Integer.parseInt(sets[1][set]));      // Variable que contiene los puntos del jugador 2 en el set en juego.
        if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1))) || ((j1 == 7) || (j2 == 7) && (nSet < 4))) {// Condicion para determinar si se galo el set en juego.
            ganadorSet = true;
        }
        while (ganadorSet == false) {                     // Mientras no se halla ganado el set.
            if ((j1 == j2) && ((j1 == 6) && (j2 == 6))) { // Condicion para determinar si se debe jugar un tieBreak o muerte subita
                if (set == 4) {                           // Condicion para jugar muerte subita
                    jugarDobleGame();                     // Se juega la muerte subita
                    ganadorSet = true;                    // Ya se gano el set.
                } else {                                  // De lo contrario:
                    ganadorTieBreak = jugarTieBreak(set); // Se juega el tieBreak.
                    ganadorSet = true;                    // Ya se gano el set.
                    if (ganadorTieBreak == true) {        // Condicion para determinar quien gano el tieBreak
                        setJ1++;                          // Si el set lo gano el jugador 1 se incrementan los sets ganados del jugador 1.
                    } else {                              // De lo contrario:
                        setJ2++;                          // Si el set lo gano el jugador 2 se incrementan los sets ganados del jugador 2.
                    }
                }
            } else {                                      // De lo contrario 
                game = jugarGame();                       // Se juega un game normal.
                if (game == true) {                       // Si el game lo gano el jugador 1.
                    sets[0][set] = ((Integer.parseInt(sets[0][set])) + 1) + ""; // Se incrementa un game en el set en juego del jugador 1.
                } else {                                  // De lo contrario:
                    sets[1][set] = ((Integer.parseInt(sets[1][set])) + 1) + ""; // Se incrementa un game en el set en juego del jugador 2.
                }
            }
            j1 = (Integer.parseInt(sets[0][set]));
            j2 = (Integer.parseInt(sets[1][set]));
            if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1)))) {//Condicion para determinar si ya se gano el set en juego.
                ganadorSet = true;
                if (j1 > j2) {// Sí el set lo gano el jugador 1
                    setJ1++;  // Se incrementa un set al jugador 1.
                } else {      // De lo contratio:
                    setJ2++;  // Se incrementa un set al jugador 2.
                }
            }
        }
    }

    /**
     *
     * @param set
     * @return
     */
    public boolean jugarTieBreak(int set) { // Metodo que ejecuta un tieBreak
        sets[0][5] = "0";
        sets[1][5] = "0";
        int j1 = 0;  // Variable que acumula los putos del jugador 1 en el tiebreak.
        int j2 = 0;  // Variable que acumula los putos del jugador 2 en el tiebreak.
        boolean ganarTieBreak = false; // Variable que determina si ya se gano el tieBreak.
        boolean punto = false;         // Varable que determina quien gana el siguiente punto del tieBreak.
        while (ganarTieBreak == false) { // Mientras no se halla ganado el tieBreak.
            if (((j1 > 5) && (j2 < (j1 - 1))) || ((j2 > 5) && (j1 < (j2 - 1)))) { // Condicion para determinar si ya se gano el tieBreak.
                ganarTieBreak = true;
            } else { // De lo contrario:
                punto = generarPuntos(); // Se genera un nuevo punto.
                if (punto == true) {     // Sí el punto lo gano el jugador 1.
                    sets[0][5] = ((Integer.parseInt(sets[0][5])) + 1) + ""; // Se incrementa un punto al jugador 1.
                } else { // De lo contrario:
                    sets[1][5] = ((Integer.parseInt(sets[1][5])) + 1) + ""; // Se incrementa un punto al jugador 2.
                }
            }
            j1 = (Integer.parseInt(sets[0][5]));
            j2 = (Integer.parseInt(sets[1][5]));
        }
        if (punto == true) { // Sí el ultimo punto lo gano el jugador 1, significa que el jugador 1 gano el tiebreak.
            sets[0][set] = "7"; // Por lo tanto el jugador 1 llega a 7 games ganados.
        } else { // De lo contrario:
            sets[1][set] = "7"; // El jugador 2 llega a 7 games ganados.
        }
        return punto;
    }

    /**
     * Metodo que ejecuta la muerte subita en el quinto set, para ganar el
     * partido cualquier jugador debe ganar por minimo 2 games de diferencia con
     * respecto al otro jugador.
     *
     * @return
     */
    public boolean jugarDobleGame() {
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
        game = j1 > j2;
        return game;
    }

    /**
     * Metodo que genera un punto al azar.
     *
     * @return
     */
    public boolean generarPuntos() {
        Random aleatorio = new Random();
        return aleatorio.nextBoolean();
    }

    /**
     *
     * Metodo que suma los puntos de un game teniendo en cuenta que la suma es:
     * 15-30-40, puede haber un deuce si ambos jugadores llegan a 40.
     *
     * @param comparador1
     * @param comparador2
     * @param punto
     */
    public void sumarPunto(int comparador1, int comparador2, boolean punto) {
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

    /**
     * Metodo que suma los puntos del tibreak en la matriz del partido.
     *
     * @param punto
     */
    public void sumarTiebreak(boolean punto) {
        if (punto == true) {
            sets[0][5] = ((Integer.parseInt(sets[0][5])) + 1) + "";
        } else {
            sets[1][5] = ((Integer.parseInt(sets[1][5])) + 1) + "";
        }
        this.setTieBreak(false);
    }

    /**
     * Metodo que determina si ya hay un ganador del game en curso.
     *
     * @param acum1
     * @param acum2
     * @param n
     * @param punto
     * @return
     */
    public boolean determinarGanadorGame(int acum1, int acum2, int n, boolean punto) {
        boolean ganador = false;
        if (((acum1 > n) && (acum2 < (acum1 - 1))) || ((acum2 > n) && (acum1 < (acum2 - 1)))) {
            ganador = true;
        }
        return ganador;
    }

    /**
     * Metodo que determina si ya hay un ganador del set en curso.
     *
     * @param n
     * @return
     */
    public boolean determinarGanadorSet(int n) {
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

    /**
     * Metodo que genera el tiempo del partido cuando se juega en automatico.
     */
    public void generarTiempoPartido() {
        if (time == false) {
            int hora, minuto, segundo, tiempoAcum;
            int tiempoJ1 = 0;
            int tiempoJ2 = 0;
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
            tiempoAcum = (segundo + (minuto * 60) + (hora * 3600));
            tiempoJ1 = (jugador1.getTiempoAcumulado() + tiempoAcum);
            tiempoJ2 = (jugador2.getTiempoAcumulado() + tiempoAcum);
            jugador1.setTiempoAcumulado(tiempoJ1);
            jugador2.setTiempoAcumulado(tiempoJ2);
        }
    }

    /**
     * Metodo que inicia la matriz del partido.
     */
    public void inicializarSets() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                sets[i][j] = "0";
            }
        }
    }

    /**
     * Metodo que acula el tiempo de los jugadores tras cada partido.
     */
    public void aculumarTiempo() {
        if ((acumulador == false) && (time == false)) {
            int acum = 0;
            String tiempos = getTiempo();
            String[] partirHora = tiempos.split(":");
            int h = Integer.parseInt(partirHora[0]);
            int m = Integer.parseInt(partirHora[1]);
            int s = Integer.parseInt(partirHora[2]);
            acum = (s + (m * 60) + (h * 3600));
            int tiempoJ1 = (jugador1.getTiempoAcumulado() + acum);
            int tiempoJ2 = (jugador2.getTiempoAcumulado() + acum);
            jugador1.setTiempoAcumulado(tiempoJ1);
            jugador2.setTiempoAcumulado(tiempoJ2);
            acumulador = true;
        }
    }

    /**
     * Metedo que acumula los puntos de cada jugador tras cada partido.
     */
    public void acumularPuntos() {
        if (time == false) {
            int codigo = Integer.parseInt(id);
            int puntos;
            if (codigo < 13) {
                if (setJ1 == 3) {
                    puntos = jugador1.getPuntosObtenidos() * 2;
                    jugador1.setPuntosObtenidos(puntos);
                } else {
                    puntos = jugador2.getPuntosObtenidos() * 2;
                    jugador2.setPuntosObtenidos(puntos);
                }
            } else if (codigo == 15) {
                if (setJ1 == 3) {
                    jugador1.setPuntosObtenidos(2000);
                    jugador2.setPuntosObtenidos(1200);
                } else {
                    jugador1.setPuntosObtenidos(1200);
                    jugador2.setPuntosObtenidos(2000);
                }
            }
        }
    }

    /**
     * Metodo Get Jugador1
     *
     * @return Jugador1
     */
    public Jugador getJugador1() {
        return jugador1;
    }

    /**
     * Metodo Get Jugador1
     *
     * @param jugador1
     */
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     * Metodo Get Jugador2
     *
     * @return Jugador2
     */
    public Jugador getJugador2() {
        return jugador2;
    }

    /**
     * Metodo Set Jugador2
     *
     * @param jugador2
     */
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    /**
     * Metodo Get Pista
     *
     * @return Pista
     */
    public Pista getPista() {
        return pista;
    }

    /**
     * Metodo Set Pista
     *
     * @param pista
     */
    public void setPista(Pista pista) {
        this.pista = pista;
    }

    /**
     * Metodo Get fecha & hora
     *
     * @return fechaHora
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Metodo Set fecha & hora
     *
     * @param fechaHora
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Metodo Get Id Partido
     *
     * @return Id Partido
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo Set Id Partido
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo Get Sets
     *
     * @return sets
     */
    public String[][] getSets() {
        return sets;
    }

    /**
     * Metodo Set Id Partido
     *
     * @param sets
     */
    public void setSets(String[][] sets) {
        this.sets = sets;
    }

    /**
     * Metodo Get Tiempo
     *
     * @return tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * Metodo Set tiempo
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
     * Metodo Set Asistencia
     *
     * @param asistencia
     */
    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    /**
     * Metodo Get Asistencia
     *
     * @return asistencia
     */
    public int getAsistencia() {
        return asistencia;
    }
}
