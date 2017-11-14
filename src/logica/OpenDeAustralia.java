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
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Shonny & juank
 */
public class OpenDeAustralia {

    private Jugador[] jugadores;
    private Pista[] pistas;
    private ArrayList<Partido> partidos;

    int aux;

    /**
     *
     */
    public OpenDeAustralia() {
        this.partidos = new ArrayList<Partido>();
        this.jugadores = new Jugador[16];
        this.pistas = new Pista[5];
    }

    /**
     *
     */
    public void generarOctavos() {
        Random aleatorio = new Random();
        Jugador jugador1 = null;
        Jugador jugador2 = null;
        Pista pista = null;
        //tomamos el primer jugador con el ultimo
        for (int i = 0; i < 8; i++) {
            jugador1 = jugadores[i];
            jugador2 = jugadores[15 - i];
            //Pista aleatoria
            pista = pistas[aleatorio.nextInt(5)];

            String idPartido = (partidos.size() + 1) + "";
            //creamos un objeto partido (llamamos al contructor para inicializar)
            Partido parti = new Partido(idPartido, jugador1, jugador2, pista);
            //agregamos al arraylist
            partidos.add(parti);
        }

    }

    /**
     *
     * @param tamArreglo
     * @param inicioArray
     * @param finalArray
     */
    public void generarPartidos(int tamArreglo, int inicioArray, int finalArray) {
        aux = -1;

        Jugador[] jugadoresCuartos = new Jugador[tamArreglo];
        Random aleatorio = new Random();
        Jugador jugadorGanador = null;
        int jugador1Acumulador;
        int jugador2Acumulador;
        Pista pista = null;
        Jugador jugador1 = null;
        Jugador jugador2 = null;
        for (int i = inicioArray; i < finalArray; i++) {
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
                jugadorGanador = partidos.get(i).getJugador1();
                aux++;
                jugadoresCuartos[aux] = jugadorGanador;
            } else if (jugador1Acumulador < jugador2Acumulador) {
                jugadorGanador = partidos.get(i).getJugador2();
                aux++;
                jugadoresCuartos[aux] = jugadorGanador;
            }
        }

        for (int i = 0; i < (tamArreglo / 2); i++) {

            jugador1 = jugadoresCuartos[i];
            jugador2 = jugadoresCuartos[(tamArreglo - 1) - i];
            //Pista aleatoria
            if (tamArreglo == 4) {
                pista = pistas[aleatorio.nextInt(2) + 0];
            } else if (tamArreglo == 2) {
                pista = pistas[0];
            } else {
                pista = pistas[aleatorio.nextInt(5)];
            }
            String idPartido = (partidos.size() + 1) + "";
            System.out.println(idPartido + "------ID PARTIDO");
            //creamos un objeto partido (llamamos al contructor para inicializar)
            Partido parti = new Partido(idPartido, jugador1, jugador2, pista);

            partidos.add(parti);

        }
    }

    /**
     *
     * @return
     */
    public Jugador ganadorTorneo() {
        int jugador1Acumulador;
        int jugador2Acumulador;
        Jugador jugadorGanador = null;
        jugador1Acumulador = 0;
        jugador2Acumulador = 0;
        for (int j = 0; j < 5; j++) {
            if (Integer.parseInt(partidos.get(14).getSets()[0][j]) > Integer.parseInt(partidos.get(14).getSets()[1][j])) {
                jugador1Acumulador++;
            } else if (Integer.parseInt(partidos.get(14).getSets()[0][j]) < Integer.parseInt(partidos.get(14).getSets()[1][j])) {
                jugador2Acumulador++;
            }
        }
        if (jugador1Acumulador > jugador2Acumulador) {
            jugadorGanador = partidos.get(14).getJugador1();
        } else if (jugador1Acumulador < jugador2Acumulador) {
            jugadorGanador = partidos.get(14).getJugador2();
        }

        return jugadorGanador;
    }

    /**
     *
     * @return
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

//    public String jugadorMayorTiempo() {
//        Jugador jugadorGanador = null;
//        int acumulador;
//        int jugador2Acumulador;
//        Jugador jugador1 = null;
//        Jugador jugador2 = null;
//        for (int i = 0; i < partidos.size(); i++) {
//            acumulador 
//        }
//    }

    /**
     *
     * @return
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
            System.out.println(jugador1Acumulador + "---- jugador1Acumulador");
            System.out.println(jugador2Acumulador + "---- jugador2Acumulador");
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
     *
     * @param id
     * @return
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
     *
     * @param juga
     * @return
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
     *
     * @param idJugador
     * @return
     */
    public Jugador buscarJugador(String idJugador) {
        for (int i = 0; i < jugadores.length; i++) {
            Jugador j = jugadores[i];
            if (j != null) {
                if (idJugador.equals(j.getIdJugador())) {
                    return j;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
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

    // se puede volver mas pequeño es una prueba
    /**
     *
     * @param id
     * @param dato
     * @param col
     */
    public void modificarJugador(String id, String dato, int col) {
        switch (col) {
            case 1:
                for (int i = 0; i < jugadores.length; i++) {
                    if (jugadores[i] != null) {
                        if (id.equals(jugadores[i].getIdJugador())) {
                            jugadores[i].setNombre(dato);
                        }
                    }
                }
                break;
            case 2:
                int edad = Integer.parseInt(dato);
                for (int i = 0; i < jugadores.length; i++) {
                    if (jugadores[i] != null) {
                        if (id.equals(jugadores[i].getIdJugador())) {
                            jugadores[i].setEdad(edad);
                        }
                    }
                }
                break;
            case 3:
                int puntosAtp = Integer.parseInt(dato);
                for (int i = 0; i < jugadores.length; i++) {
                    if (jugadores[i] != null) {
                        if (id.equals(jugadores[i].getIdJugador())) {
                            jugadores[i].setPuntosObtenidos(puntosAtp);
                        }
                    }
                }
                break;
            case 4:
                int rankinAtp = Integer.parseInt(dato);
                for (int i = 0; i < jugadores.length; i++) {
                    if (jugadores[i] != null) {
                        if (id.equals(jugadores[i].getIdJugador())) {
                            jugadores[i].setRankinATP(rankinAtp);
                        }
                    }
                }
                break;
            default:
                break;
        }

    }

    /**
     *
     * @param pis
     * @return
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
     *
     * @param id
     * @return
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
     *
     * @param idPista
     * @return
     */
    public Pista buscarPista(String idPista) {
        for (int i = 0; i < pistas.length; i++) {
            Pista p = pistas[i];
            if (p != null) {
                if (idPista.equals(p.getIdPista())) {
                    return p;
                }
            }
        }
        return null;
    }

    // se puede volver mas pequeño es una prueba
    /**
     *
     * @param id
     * @param dato
     * @param col
     */
    public void modificarPista(String id, String dato, int col) {
        switch (col) {
            case 1:
                for (int i = 0; i < pistas.length; i++) {
                    if (pistas[i] != null) {
                        if (id.equals(pistas[i].getIdPista())) {
                            pistas[i].setNombre(dato);
                        }
                    }
                }
                break;
            case 2:
                int capacidadMaxi = Integer.parseInt(dato);
                for (int i = 0; i < pistas.length; i++) {
                    if (pistas[i] != null) {
                        if (id.equals(pistas[i].getIdPista())) {
                            pistas[i].setCapacidadMax(capacidadMaxi);
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     *
     * @throws IOException
     */
    public void inicializarAtributosJugador() throws IOException {
        FileReader lector = new FileReader("src/persistencia/Jugadores.txt");
        BufferedReader entradatxt = new BufferedReader(lector);
        String linea = entradatxt.readLine();
        int i = 0;

        while (linea != null) {
            String ep[] = linea.split("--");
            Jugador nuevoJugador = new Jugador(ep[0], ep[1], Integer.parseInt(ep[2]), Integer.parseInt(ep[3]));
            jugadores[i] = nuevoJugador;
            i++;
            linea = entradatxt.readLine();
        }
        entradatxt.close();
    }

    /**
     *
     * @throws IOException
     */
    public void inicializarAtributosPista() throws IOException {
        FileReader lector = new FileReader("src/persistencia/Pistas.txt");
        BufferedReader entradatxt = new BufferedReader(lector);
        String linea = entradatxt.readLine();
        int i = 0;

        while (linea != null) {
            String pist[] = linea.split("--");
            Pista nuevaPista = new Pista(pist[0], pist[1], Integer.parseInt(pist[2]));
            pistas[i] = nuevaPista;
            i++;
            linea = entradatxt.readLine();
        }
        entradatxt.close();
    }

    /**
     *
     * @return
     */
    public Jugador[] getJugadores() {
        return jugadores;
    }

    /**
     *
     * @param jugadores
     */
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    /**
     *
     * @return
     */
    public Pista[] getPistas() {
        return pistas;
    }

    /**
     *
     * @param pistas
     */
    public void setPistas(Pista[] pistas) {
        this.pistas = pistas;
    }

    /**
     *
     * @return
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /**
     *
     * @param partidos
     */
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}
