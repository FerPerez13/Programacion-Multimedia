package com.example.fer.overwatchstats;

/**
 * Created by fer on 17/01/17.
 */

import java.io.Serializable;

public class Personaje implements Serializable{
    private String nombre;
    private int imagen;

    public Personaje(String nombre, int imagen){
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
