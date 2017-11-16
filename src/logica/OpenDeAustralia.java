/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Shonny y juank
 */
public class OpenDeAustralia {

    private Jugador[] jugadores;//arreglo de tipo jugador
    private Pista[] pistas;//arreglo de tipo pista
    private ArrayList<Partido> partidos;//arraylist de tipo Partido

    int aux;//variable axiliar que es un acumulador para el metodo generar partidos

    /**
     * Constructor
     */
    public OpenDeAustralia() {
        this.partidos = new ArrayList<Partido>();
        this.jugadores = new Jugador[16];
        this.pistas = new Pista[5];
    }

    /**
     * Generar los octavos
     */
    public void generarOctavos() {
        Random aleatorio = new Random();//clase ramdon de java
        Jugador jugador1 = null;//jugador 1
        Jugador jugador2 = null;//jugador2
        Pista pista = null;//pista
        //tomamos el primer jugador con el ultimo y asi sucesivamente
        for (int i = 0; i < 8; i++) {
            jugador1 = jugadores[i];//primera posiciones del arreglo de jugadores
            jugador2 = jugadores[15 - i];//ultima posicion del arreglo de jugadores
            //Pista aleatoria
            pista = pistas[aleatorio.nextInt(5)];

            String idPartido = (partidos.size() + 1) + "";//contador para generar el id del partido
            //creamos un objeto partido (llamamos al contructor para inicializar)
            Partido parti = new Partido(idPartido, jugador1, jugador2, pista);
            //agregamos al arraylist
            partidos.add(parti);
        }

    }

    /**
     * metodo que genera todos los partidos, generan los octavos en las 8
     * primeras posiciones del arraylist, luego genera apartir de esos 8
     * primeras posiciones los octavos lo mismo para semifinal y final
     *
     * @param tamArreglo Parametro que sirve para inicializar el arreglo interno
     * del metodo
     * @param inicioArray Parametro para inicializar el inicio del arraylist
     * @param finalArray Parametro para inicializar el limite del arraylist
     */
    public void generarPartidos(int tamArreglo, int inicioArray, int finalArray) {
        aux = -1;

        Jugador[] jugadoresCuartos = new Jugador[tamArreglo];//se crea un arreglo del tipo jugador
        Random aleatorio = new Random();//Clase random java
        Jugador jugadorGanador = null;//variable de tipo jugador
        int jugador1Acumulador;//acumulador para jugador1
        int jugador2Acumulador;//acumulador para jugador2
        Pista pista = null;//variable de tipo pista
        Jugador jugador1 = null;//jugador1
        Jugador jugador2 = null;//jugador2
        for (int i = inicioArray; i < finalArray; i++) {//ciclo que recorre el arraylist
            jugador1Acumulador = 0;//se inicializan el acumulador en 0
            jugador2Acumulador = 0;//se inicializa el acumuladore en 0
            //recorre la matriz de los sets y va acumulando
            for (int j = 0; j < 5; j++) {
                //verifica cada cada set y cuando el set es mayor acumula
                if (Integer.parseInt(partidos.get(i).getSets()[0][j]) > Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador1Acumulador++;
                } else if (Integer.parseInt(partidos.get(i).getSets()[0][j]) < Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador2Acumulador++;
                }
            }
            //compara los acumuladores para definir el ganador y los guarda en un arreglo
            if (jugador1Acumulador > jugador2Acumulador) {
                //si el acumulador jugador1 es mayor es por que gano el jugador1, aumenta el aux y guarda ese jugador en una posicion del arreglo del metodo
                jugadorGanador = partidos.get(i).getJugador1();
                aux++;
                jugadoresCuartos[aux] = jugadorGanador;
            } else if (jugador1Acumulador < jugador2Acumulador) {
                //si el acumulador jugador2 es mayor es por que gano el jugador2, aumenta el aux y guarda ese jugador en una posicion del arreglo del metodo
                jugadorGanador = partidos.get(i).getJugador2();
                aux++;
                jugadoresCuartos[aux] = jugadorGanador;
            }
        }
        //for que recorre el arreglo interno del metodo y empareja los jugadores el primero con el ultimo asi sucesivamente
        for (int i = 0; i < (tamArreglo / 2); i++) {
            jugador1 = jugadoresCuartos[i];//jugador de la primera posicion
            jugador2 = jugadoresCuartos[(tamArreglo - 1) - i];//jugador de la ultima posicion
            //Pista aleatoria
            switch (tamArreglo) {
                case 4:
                    //si es semifinal
                    pista = pistas[aleatorio.nextInt(2) + 0];
                    break;
                case 2:
                    //si es final
                    pista = pistas[0];
                    break;
                default:
                    //para cualquiera etapa
                    pista = pistas[aleatorio.nextInt(5)];
                    break;
            }
            String idPartido = (partidos.size() + 1) + "";//auto incremnto del id
            //creamos un objeto partido (llamamos al contructor para inicializar)
            Partido parti = new Partido(idPartido, jugador1, jugador2, pista);
            //agregados el partido al arraylist
            partidos.add(parti);

        }
    }

    /**
     * metodo que verifica en la ultima posicion del arraylist que jugador gano
     *
     * @return Jugador ganador del torneo
     */
    public Jugador ganadorTorneo() {
        int jugador1Acumulador;
        int jugador2Acumulador;
        Jugador jugadorGanador = null;
        jugador1Acumulador = 0;
        jugador2Acumulador = 0;
        //recorre la matriz de los sets y va acumulando
        for (int j = 0; j < 5; j++) {
            //verifica cada cada set y cuando el set es mayor acumula
            if (Integer.parseInt(partidos.get(14).getSets()[0][j]) > Integer.parseInt(partidos.get(14).getSets()[1][j])) {
                jugador1Acumulador++;
            } else if (Integer.parseInt(partidos.get(14).getSets()[0][j]) < Integer.parseInt(partidos.get(14).getSets()[1][j])) {
                jugador2Acumulador++;
            }
        }
        //compara los acumuladores para definir el ganador
        if (jugador1Acumulador > jugador2Acumulador) {
            //si el acumulador jugador1 es mayor es por que gano el jugador1 y retorna
            jugadorGanador = partidos.get(14).getJugador1();
        } else if (jugador1Acumulador < jugador2Acumulador) {
            //si el acumulador jugador2 es mayor es por que gano el jugador2 y retorna
            jugadorGanador = partidos.get(14).getJugador2();
        }

        return jugadorGanador;
    }

    /**
     * busca en todo el arraylist de partidos que partido tiene mayor asistencia
     *
     * @return Partido
     */
    public Partido mayorAsistencia() {
        Partido respuesta = null;
        int mayorAsistencia = 0;
        for (int i = 0; i < partidos.size(); i++) {
            if (mayorAsistencia < partidos.get(i).getAsistencia()) {
                mayorAsistencia = partidos.get(i).getAsistencia();
                respuesta = partidos.get(i);
            }
        }
        return respuesta;
    }

    /**
     * Metodo que determina cual jugador duro mas tiempo en cancha.
     * @return String
     */
    public String jugadorMayorTiempo() {
        Jugador miJugador = null;
        int tiempo = 0;
        String res = "";
        String nombre = "";
        String time;
        for (int i = 0; i < 16; i++) {
            miJugador = jugadores[i];
            if (miJugador.getTiempoAcumulado() > tiempo) {
                nombre = miJugador.getNombre();
                tiempo = miJugador.getTiempoAcumulado();
            }
        }
        time = convertirTiempo(tiempo);
        res = (nombre + "  " + time);
        return res;
    }

    /**
     * Metodo que determina cual jugador duro menos tiempo en cancha.
     * @return String
     */
    public String jugadorMenorTiempo() {
        Jugador miJugador = null;
        int tiempo = jugadores[0].getTiempoAcumulado();
        String res = "";
        String nombre = "";
        String time;
        for (int i = 0; i < 16; i++) {
            miJugador = jugadores[i];
            if (miJugador.getTiempoAcumulado() <= tiempo) {
                nombre = miJugador.getNombre();
                tiempo = miJugador.getTiempoAcumulado();
            }
        }
        time = convertirTiempo(tiempo);
        if (tiempo == 0) {
            res = time;
        } else {
            res = (nombre + " " + time);
        }
        return res;
    }

    /**
     * Metodo que convierte de segundos a horas minutos y segundos el tiempo el tiempo del jugador. 
     * @return String
     */
    private String convertirTiempo(int tiempo) {
        String res, min, seg;
        int h, m, s;
        h = tiempo / 3600;
        m = (tiempo % 3600) / 60;
        s = (tiempo % 3600) % 60;
        min = m + "";
        seg = s + "";
        if (m < 10) {
            min = ("0" + m);
        }
        if (s < 10) {
            seg = ("0" + s);
        }
        res = (h + ":" + min + ":" + seg);
        return res;
    }

    /**
     * Recorre todo el arraylist contando el numero de ganadores, para ello
     * tiene que entrar en la matriz de sets, acumular los sets ganados y luego
     * se mira de quien son esos set y se suma un punto que define un ganador
     * del torneo
     *
     * @return numero de ganadores
     */
    public int numeroGanadores() {
        int jugador1Acumulador;
        int jugador2Acumulador;
        int res = 0;
        Jugador jugadorGanador = null;
        for (int i = 0; i < partidos.size(); i++) {
            jugador1Acumulador = 0;
            jugador2Acumulador = 0;
            //recorre la matriz de los sets y va acumulando
            for (int j = 0; j < 5; j++) {
                if (Integer.parseInt(partidos.get(i).getSets()[0][j]) > Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador1Acumulador++;
                } else if (Integer.parseInt(partidos.get(i).getSets()[0][j]) < Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador2Acumulador++;
                }
            }
            //compara los acumuladores para definir el ganador y los guarda en una matriz
            if (jugador1Acumulador > jugador2Acumulador) {
                res++;
            } else if (jugador1Acumulador < jugador2Acumulador) {
                res++;
            }
        }

        return res;
    }

    /**
     * Busca un partido por ID
     *
     * @param id id partido
     * @return Partido
     */
    public Partido buscarPartido(String id) {
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            if (id.equals(partido.getId())) {
                return partido;
            }
        }
        return null;
    }

    /**
     * Agrega un jugador primero verificando si existe mediante el id
     *
     * @param juga Objeto de tipo Jugadores
     * @return true si agrego false si no agrego el Jugador
     */
    public boolean agregarJugador(Jugador juga) {
        String id = juga.getIdJugador();
        Jugador verificacion = buscarJugador(id);

        if (verificacion == null) {
            for (int i = 0; i < jugadores.length; i++) {
                if (jugadores[i] == null) {
                    jugadores[i] = juga;
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Buscar el jugador por medio del ID en el arreglo
     *
     * @param idJugador id del jugador
     * @return un Juagador
     */
    public Jugador buscarJugador(String idJugador) {
        for (Jugador j : jugadores) {
            if (j != null) {
                if (idJugador.equals(j.getIdJugador())) {
                    return j;
                }
            }
        }
        return null;
    }

    /**
     * Busca en el arreglo el id y si lo encuentra lo elimina
     *
     * @param id id del jugador
     * @return true si elimino false si no lo elimino
     */
    public boolean eliminarJugador(String id) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null) {
                if (id.equals(jugadores[i].getIdJugador())) {
                    jugadores[i] = null;
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Este metodo sirve para modificar los datos directamente desde las celdas
     * de la tabla
     *
     * @param id id del Jugador
     * @param dato dato modificado
     * @param col indica que variable se va modificar (es el numero de la
     * columna)
     */
    public void modificarJugador(String id, String dato, int col) {
        switch (col) {
            case 1:
                for (Jugador jugadore : jugadores) {
                    if (jugadore != null) {
                        if (id.equals(jugadore.getIdJugador())) {
                            jugadore.setNombre(dato);
                        }
                    }
                }
                break;
            case 2:
                int edad = Integer.parseInt(dato);
                for (Jugador jugadore : jugadores) {
                    if (jugadore != null) {
                        if (id.equals(jugadore.getIdJugador())) {
                            jugadore.setEdad(edad);
                        }
                    }
                }
                break;
            case 3:
                int puntosAtp = Integer.parseInt(dato);
                for (Jugador jugadore : jugadores) {
                    if (jugadore != null) {
                        if (id.equals(jugadore.getIdJugador())) {
                            jugadore.setPuntosObtenidos(puntosAtp);
                        }
                    }
                }
                break;
            default:
                break;
        }

    }

    /**
     * Este metodo agrega una pista verificando primero si la pista existe
     * mediante el id
     *
     * @param pis objeto de tipo Pista
     * @return true si lo agrego false si no lo agrego
     */
    public boolean agregarPista(Pista pis) {
        String id = pis.getIdPista();
        Pista verificacion = buscarPista(id);

        if (verificacion == null) {
            for (int i = 0; i < pistas.length; i++) {
                if (pistas[i] == null) {
                    pistas[i] = pis;
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * metodo que elimina una pista mediante el id
     *
     * @param id id de la pista
     * @return true si se elimino y false si no se elimino
     */
    public boolean eliminarPista(String id) {
        for (int i = 0; i < pistas.length; i++) {
            if (pistas[i] != null) {
                if (id.equals(pistas[i].getIdPista())) {
                    pistas[i] = null;
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Metodo que busca una pista por el id
     *
     * @param idPista id de la pista
     * @return Pista
     */
    public Pista buscarPista(String idPista) {
        for (Pista p : pistas) {
            if (p != null) {
                if (idPista.equals(p.getIdPista())) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * Este metodo sirve para modificar los datos de la pista directamente desde
     * la tabla
     *
     * @param id de la pista
     * @param dato dato modificado
     * @param col indica que variable se va modificar (es el numero de la
     * columna)
     */
    public void modificarPista(String id, String dato, int col) {
        switch (col) {
            case 1:
                for (Pista pista : pistas) {
                    if (pista != null) {
                        if (id.equals(pista.getIdPista())) {
                            pista.setNombre(dato);
                        }
                    }
                }
                break;
            case 2:
                int capacidadMaxi = Integer.parseInt(dato);
                for (Pista pista : pistas) {
                    if (pista != null) {
                        if (id.equals(pista.getIdPista())) {
                            pista.setCapacidadMax(capacidadMaxi);
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * Metodo que carga el archivo Jugadores.txt en el arreglo (persistencia)
     *
     * @throws IOException excepción del archivo
     */
    public void inicializarAtributosJugador() throws IOException {
        FileReader lector = new FileReader("src/persistencia/Jugadores.txt");//Inicializa la variable con la ruta del archivo
        try (BufferedReader entradatxt = new BufferedReader(lector)) {//excepción
            String linea = entradatxt.readLine();//guarda una linea del archivo en la variable
            int i = 0;

            while (linea != null) {
                String ep[] = linea.split("--");//hace split a la linea para separarla y irla guardando en el arreglo
                Jugador nuevoJugador = new Jugador(ep[0], ep[1], Integer.parseInt(ep[2]));
                jugadores[i] = nuevoJugador;
                i++;
                linea = entradatxt.readLine();
            }
        }
    }

    /**
     * Metodo que carga el archivo Pistas.txt en el arreglo (persistencia)
     *
     * @throws IOException excepción del archivo
     */
    public void inicializarAtributosPista() throws IOException {
        FileReader lector = new FileReader("src/persistencia/Pistas.txt");//Inicializa la variable con la ruta del archivo
        try (BufferedReader entradatxt = new BufferedReader(lector)) {//excepción
            String linea = entradatxt.readLine();//guarda una linea del archivo en la variable
            int i = 0;

            while (linea != null) {
                String pist[] = linea.split("--");//hace split a la linea para separarla y irla guardando en el arreglo
                Pista nuevaPista = new Pista(pist[0], pist[1], Integer.parseInt(pist[2]));
                pistas[i] = nuevaPista;
                i++;
                linea = entradatxt.readLine();
            }
        }
    }

    /**
     * Metodo Get Jugadores
     *
     * @return arreglo de jugadores
     */
    public Jugador[] getJugadores() {
        return jugadores;
    }

    /**
     * Metodo Set Jugadores
     *
     * @param jugadores arreglo de Jugadores
     */
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Metodo Get Pistas
     *
     * @return Un arreglo de tipo Pistas
     */
    public Pista[] getPistas() {
        return pistas;
    }

    /**
     * Metodo Set Pistas
     *
     * @param pistas pista
     */
    public void setPistas(Pista[] pistas) {
        this.pistas = pistas;
    }

    /**
     * Metodo Get Patidos
     *
     * @return Un ArrayList de tipo Patidos
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /**
     * Metodo Get partidos
     *
     * @param partidos recibe un ArrayList
     */
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

}
