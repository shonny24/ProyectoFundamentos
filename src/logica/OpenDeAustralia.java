/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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
        String cedu = juga.getIdJugador();
        Jugador verificacion = buscarJugador(cedu);

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
            Jugador p = jugadores[i];
            if (p != null) {
                if (idJugador.equals(p.getIdJugador())) {
                    return p;
                }
            }
        }
        return null;
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
