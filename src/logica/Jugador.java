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
    public int tiempoAcumulado;

    /**
     *
     * @param idJugador
     * @param nombre
     * @param edad
     * @param rankinATP
     */
    public Jugador(String idJugador, String nombre, int edad, int rankinATP) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.edad = edad;
        this.rankinATP = rankinATP;
        this.puntosObtenidos = 180;
        this.tiempoAcumulado=0;
    }

    /**
     *
     * @return
     */
    public String getIdJugador() {
        return idJugador;
    }

    /**
     *
     * @param idJugador
     */
    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *
     * @return
     */
    public int getRankinATP() {
        return rankinATP;
    }

    /**
     *
     * @param rankinATP
     */
    public void setRankinATP(int rankinATP) {
        this.rankinATP = rankinATP;
    }

    /**
     *
     * @return
     */
    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    /**
     *
     * @param puntosObtenidos
     */
    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }
    
    /**
     *
     * @param tiempoAcumulado
     */
    public void setTiempoAcumulado(int tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    /**
     *
     * @return
     */
    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }
}
