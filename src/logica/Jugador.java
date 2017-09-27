/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Shonny & Juank
 */
public class Jugador {

    private String idJugador;
    private String nombre;
    private int edad;
    private int rankinATP;
    private int puntosObtenidos;

    public Jugador(String idJugador, String nombre, int edad, int rankinATP, int puntosObtenidos) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.edad = edad;
        this.rankinATP = rankinATP;
        this.puntosObtenidos = puntosObtenidos;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getRankinATP() {
        return rankinATP;
    }

    public void setRankinATP(int rankinATP) {
        this.rankinATP = rankinATP;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }
}
