package com.splash.banana.estudioscondave;

import java.io.Serializable;

/**
 * Created by fernando on 18/11/16.
 */

public class Campeon implements Serializable {

    private String nombre;
    private int imagen;

    public Campeon(String nombre, int imagen){
        this.nombre=nombre;
        this.imagen=imagen;
    }
    public String getNombre() {
        return nombre;
    }
    public int getImagen() {
        return imagen;
    }

}
