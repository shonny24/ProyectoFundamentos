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

    private String idJugador;//id del partido
    private String nombre;//nombre del jugador
    private int edad;//edad del jugador
    private int puntosObtenidos;//puntos obtenidos del jugador
    public int tiempoAcumulado;//tiempo acumulado del jugador

    /**
     * Contructor de la clase Jugador
     *
     * @param idJugador
     * @param nombre
     * @param edad
     *
     */
    public Jugador(String idJugador, String nombre, int edad) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.edad = edad;
        this.puntosObtenidos = 180;//se inicializa 180 puntos ya que se juega desde los octavos de final
        this.tiempoAcumulado = 0;//se inicializa en 0 ya que en ese momento no se han jugado partidos
    }

    /**
     * Metodo Get id Jugador
     *
     * @return id del jugador
     */
    public String getIdJugador() {
        return idJugador;
    }

    /**
     * Metodo Set id Jugador
     *
     * @param idJugador id del jugador
     */
    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * Metodo Get Nombre
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo Set Nombre
     *
     * @param nombre Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo Get Edad
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo Set edad
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo Get Puntos Obtenidos
     *
     * @return puntos obtenidos
     */
    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    /**
     * Metodo Set Puntos Obtenidos
     *
     * @param puntosObtenidos Puntos obtenidos
     */
    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    /**
     * Metodo Set Tiempo Acumulado
     *
     * @param tiempoAcumulado
     */
    public void setTiempoAcumulado(int tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    /**
     * Metodo Get Tiempo Acumulado
     *
     * @return tiempo acumulado
     */
    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }
}
