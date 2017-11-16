/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Shonny y juank
 */
public class Pista {
    private String idPista;
    private String nombre;
    private int capacidadMax;

    /**
     * Constructor
     * 
     * @param idPista ide la pista
     * @param nombre nombre de la pista
     * @param capacidadMax capacidad maxima de la pista
     */
    public Pista(String idPista, String nombre, int capacidadMax) {
        this.idPista = idPista;
        this.nombre = nombre;
        this.capacidadMax = capacidadMax;
    }

    /**
     * Metodo Get id Pista 
     * @return idPista
     */
    public String getIdPista() {
        return idPista;
    }

    /**
     * Metodo Set id Pista 
     * @param idPista String
     */
    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    /**
     * Metodo Get Nombre
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo Set Nombre
     * @param nombre Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo Get Capacidad Maxima
     * @return capacidadMaxima
     */
    public int getCapacidadMax() {
        return capacidadMax;
    }

    /**
     * Metodo Set Capacidad Maxima
     * @param capacidadMax entero
     */
    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }


}
