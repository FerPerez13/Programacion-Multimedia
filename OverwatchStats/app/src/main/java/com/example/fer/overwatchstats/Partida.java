package com.example.fer.overwatchstats;

import java.io.Serializable;

/**
 * Created by fer on 9/02/17.
 */

public class Partida implements Serializable {

    private String nombre;
    private int imagen;
    private int gana;
    private int pierde;
    private int empata;
    private int asesinatos;
    private int muertes;
    private int asistencias;
    private double dañoHecho;
    private double dañoRec;

    public Partida() {
    }

    private int cambio;

    public Partida(String nombre, int imagen, int gana, int pierde, int empata, int asesinatos, int muertes, int asistencias, double dañoHecho, double dañoRec) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.gana = gana;
        this.pierde = pierde;
        this.empata = empata;
        this.asesinatos = asesinatos;
        this.muertes = muertes;
        this.asistencias = asistencias;
        this.dañoHecho = dañoHecho;
        this.dañoRec = dañoRec;
    }

    public String getNombre() {return nombre;}

    public int getImagen() {return imagen;}

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

    public int getGana() {return gana;}

    public void setGana(int gana) {this.gana = gana;}

    public int getPierde() {return pierde;}

    public void setPierde(int pierde) {this.pierde = pierde;}

    public int getEmpata() {return empata;}

    public void setEmpata(int empata) {this.empata = empata;}

}
