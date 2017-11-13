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
public class Pista {
    private String idPista;
    private String nombre;
    private int capacidadMax;

    /**
     *
     * @param idPista
     * @param nombre
     * @param capacidadMax
     */
    public Pista(String idPista, String nombre, int capacidadMax) {
        this.idPista = idPista;
        this.nombre = nombre;
        this.capacidadMax = capacidadMax;
    }

    /**
     *
     * @return
     */
    public String getIdPista() {
        return idPista;
    }

    /**
     *
     * @param idPista
     */
    public void setIdPista(String idPista) {
        this.idPista = idPista;
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
    public int getCapacidadMax() {
        return capacidadMax;
    }

    /**
     *
     * @param capacidadMax
     */
    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }


}
