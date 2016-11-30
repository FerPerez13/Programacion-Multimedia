package com.example.mati.alquilerdecoches;

import java.io.Serializable;

/**
 * Created by mati on 21/11/16.
 */

public class Seleccion implements Serializable {
    private Coche coche;
    private String tiempo;
    private int seguro;
    private int extras;
    private double precio;

    public Seleccion() {
        this.coche = null;
        this.tiempo = "";
        this.seguro = 0;
        this.extras=0;
        this.precio= 0;
    }

    public Seleccion(Coche coche, String tiempo,int seguro, int extras, double precio) {
        this.coche = coche;
        this.tiempo = tiempo;
        this.seguro = seguro;
        this.extras=extras;
        this.precio = precio;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setSeguro(int seguro){ this.seguro = seguro;}

    public void setExtras(int extras){ this.extras=extras; }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTiempo() { return tiempo; }

    public int getSeguro(){ return seguro; }

    public int getExtras(){return extras;}

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Seleccion{" +
                "coche=" + coche +
                ", tiempo='" + tiempo + '\'' +
                ", seguro='" + seguro + '\'' +
                ", extras='" + extras + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
