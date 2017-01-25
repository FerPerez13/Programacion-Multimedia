package com.example.fer.overwatchstats;

/**
 * Created by fer on 17/01/17.
 */

import java.io.Serializable;

public class Personaje implements Serializable{
    private String nombre;
    private int imagen;
    private int asesinatos;
    private int muertes;
    private int asistencias;
    private double dañoHecho;
    private double dañoRec;

    public Personaje(){
        this.nombre="";
        this.imagen=0;
        this.asesinatos = 0;
        this.muertes = 0;
        this.asistencias = 0;
        this.dañoHecho = 0;
        this.dañoRec = 0;
    }

    public Personaje(String nombre, int imagen){
        this.nombre=nombre;
        this.imagen=imagen;
        this.asesinatos = 0;
        this.muertes = 0;
        this.asistencias = 0;
        this.dañoHecho = 0;
        this.dañoRec = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getAsesinatos() {
        return asesinatos;
    }

    public void setAsesinatos(int asesinatos) {
        this.asesinatos = asesinatos;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public double getDañoHecho() {
        return dañoHecho;
    }

    public void setDañoHecho(double dañoHecho) {
        this.dañoHecho = dañoHecho;
    }

    public double getDañoRec() {
        return dañoRec;
    }

    public void setDañoRec(double dañoRec) {
        this.dañoRec = dañoRec;
    }
}
