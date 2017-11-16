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
     *Contructor de la clase Jugador
     * @param idJugador
     * @param nombre
     * @param edad
     * @param rankinATP
     */
    public Jugador(String idJugador, String nombre, int edad) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.edad = edad;
        this.puntosObtenidos = 180;//se inicializa 180 puntos ya que se juega desde los octavos de final
        this.tiempoAcumulado=0;//se inicializa en 0 ya que en ese momento no se han jugado partidos
    }

    /**
     * Metodo Get id Jugador
     * @return id del jugador
     */
    public String getIdJugador() {
        return idJugador;
    }

    /**
     *Metodo Set id Jugador
     * @param idJugador id del jugador
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
