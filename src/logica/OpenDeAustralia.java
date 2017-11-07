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
 * @author Shonny & juank
 */
public class OpenDeAustralia {

    private Jugador[] jugadores;
    private Pista[] pistas;

    private ArrayList<Partido> partidos;
    int aux = -1;

    public OpenDeAustralia() {
        this.partidos = new ArrayList<Partido>();
        this.jugadores = new Jugador[16];
        this.pistas = new Pista[5];
    }

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

    public void generarCuartos() {
        Jugador[] jugadoresCuartos = new Jugador[8];
        Random aleatorio = new Random();
        Jugador jugadorGanador = null;
        int jugador1Acumulador ;
        int jugador2Acumulador;
        Pista pista = null;
        Jugador jugador1 = null;
        Jugador jugador2 = null;
        for (int i = 0; i < 8; i++) {
            jugador1Acumulador = 0;
            jugador2Acumulador = 0;
            //recorre la matriz de los sets y va acumulando
            for (int j = 0; j < 5; j++) {
                if (Integer.parseInt(partidos.get(i).getSets()[0][j]) > Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador1Acumulador++;
                } else if(Integer.parseInt(partidos.get(i).getSets()[0][j]) < Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador2Acumulador++;
                }
            }
            System.out.println(aux + " AUXILIAR---------");

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

            System.out.println(aux + " AUXILIAR");
        }
        aux = 0;

        for (int i = 0; i < 4; i++) {

            jugador1 = jugadoresCuartos[i];
            jugador2 = jugadoresCuartos[7 - i];
            //Pista aleatoria
            pista = pistas[aleatorio.nextInt(5)];
            String idPartido = (partidos.size() + 1) + "";
            System.out.println(idPartido + "------ID PARTIDO");
            //creamos un objeto partido (llamamos al contructor para inicializar)
            Partido parti = new Partido(idPartido, jugador1, jugador2, pista);

            partidos.add(parti);

        }
    }
    
        public void generarFinal() {
        Jugador[] jugadoresCuartos = new Jugador[4];
        Random aleatorio = new Random();
        Jugador jugadorGanador = null;
        int jugador1Acumulador ;
        int jugador2Acumulador;
        Pista pista = null;
        Jugador jugador1 = null;
        Jugador jugador2 = null;
        for (int i = 7; i < 12; i++) {
            jugador1Acumulador = 0;
            jugador2Acumulador = 0;
            //recorre la matriz de los sets y va acumulando
            for (int j = 0; j < 5; j++) {
                if (Integer.parseInt(partidos.get(i).getSets()[0][j]) > Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador1Acumulador++;
                } else if(Integer.parseInt(partidos.get(i).getSets()[0][j]) < Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador2Acumulador++;
                }
            }
            System.out.println(aux + " AUXILIAR---------");

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

            System.out.println(aux + " AUXILIAR");
        }
        aux = 0;

        for (int i = 0; i < 4; i++) {

            jugador1 = jugadoresCuartos[i];
            jugador2 = jugadoresCuartos[3 - i];
            //Pista aleatoria
            pista = pistas[aleatorio.nextInt(5)];
            String idPartido = (partidos.size() + 1) + "";
            System.out.println(idPartido + "------ID PARTIDO");
            //creamos un objeto partido (llamamos al contructor para inicializar)
            Partido parti = new Partido(idPartido, jugador1, jugador2, pista);

            partidos.add(parti);

        }
    }

    public int numeroGanadores() {
        int jugador1Acumulador;
        int jugador2Acumulador;
        int res = 0;
        Jugador jugadorGanador = null;
        for (int i = 0; i < 8; i++) {
            jugador1Acumulador = 0;
            jugador2Acumulador = 0;
            //recorre la matriz de los sets y va acumulando
            for (int j = 0; j < 5; j++) {
                if (Integer.parseInt(partidos.get(i).getSets()[0][j]) > Integer.parseInt(partidos.get(i).getSets()[1][j])) {
                    jugador1Acumulador++;
                } else if(Integer.parseInt(partidos.get(i).getSets()[0][j]) < Integer.parseInt(partidos.get(i).getSets()[1][j])) {
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

    public Partido buscarPartido(String id) {
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            if (id.equals(partido.getId())) {
                return partido;
            }
        }
        return null;
    }

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

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Pista[] getPistas() {
        return pistas;
    }

    public void setPistas(Pista[] pistas) {
        this.pistas = pistas;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}
