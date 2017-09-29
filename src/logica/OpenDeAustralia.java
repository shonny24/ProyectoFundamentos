/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Shonny & juank
 */
public class OpenDeAustralia {

    private Jugador[] jugadores;
    private Pista[] pistas;

    public OpenDeAustralia() {
        this.jugadores = new Jugador[16];
        this.pistas = new Pista[5];
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

    public void inicializarAtributos() throws IOException {
        FileReader lector = new FileReader("src/persistencia/Jugadores.txt");
        BufferedReader entradatxt = new BufferedReader(lector);
        String linea = entradatxt.readLine();
        int i = 0;

        while (linea != null) {
            String ep[] = linea.split("--");
            Jugador nuevoJugador = new Jugador(ep[0], ep[1], Integer.parseInt(ep[2]), Integer.parseInt(ep[3]), Integer.parseInt(ep[4]));
            jugadores[i] = nuevoJugador;
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

}
