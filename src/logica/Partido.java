/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Shonny
 */
public class Partido {
    private Jugador jugador1;
    private Jugador jugador2;
    private Pista pista;
    private Estadistica estadistica;
    private String fechaHora;

    public Partido(Jugador jugador1, Jugador jugador2, Pista pista) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.pista = pista;
//        this.estadistica = estadistica;
        this.fechaHora = fechaHoraAleatoria();
    }

    
    public String fechaHoraAleatoria(){
        Calendar unaFecha = Calendar.getInstance();
        Random aleatorio = new Random();

//        Expresión                         Distancia
//        generator.nextInt(100)            0 a 99
//        generator.nextInt(256)            0 a 255
//        generator.nextInt(6) + 1          1 a 6
//        generator.nextInt(20) + 100       100 a 119
//        generator.nextInt(50) - 10        -10 a 39
//        generator.nextInt(10) - 50        -50 a -41
//
//         Un valor long
//        sr.nextLong();
//         Un valor int
//        sr.nextInt();
//         Un valor float
//        sr.nextFloat();
//         Un valor double
//        sr.nextDouble();
//         Un valor gaussian (entre -1 y 1))
//        sr.nextGaussian();
//         Un valor boolean, como lanzar una moneda
//        sr.nextBoolean();
//         ... y un valor int entre 0 (inclusivo) y int n (exclusivo)
//        sr.nextInt(n);
//         Así para tener un valor entero aleatorio de 1 al 10, se usa
//        sr.nextInt(10)+1;
//
//            kk = Hours in 1-24 format
//            hh= hours in 1-12 format
//            KK= hours in 0-11 format
//            HH= hours in 0-23 format
//
//            Año
//
//            "yy" -> "03″
//
//            "yyyy" -> "2003″
//
//            Mes
//
//            "M" -> "7″
//
//            "M" -> "12″
//
//            "MM" -> "07″
//
//            "MMM" -> "Jul"
//
//            "MMMM" -> "Deciembre"
//
//            Día del mes
//
//            "d" -> "3″
//
//            "dd" -> "03″
//
        
            unaFecha.set(2017, aleatorio.nextInt(3) + 9, aleatorio.nextInt(30) + 1, aleatorio.nextInt(24) + 1, aleatorio.nextInt(60));
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa -- dd/MMMMM/yyyy");
            String fechaHora = sdf.format(unaFecha.getTime());

        return fechaHora;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
}
