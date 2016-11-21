package com.example.mati.alquilerdecoches;

import java.io.Serializable;

/**
 * Created by mati on 21/11/16.
 */
public class Seleccion implements Serializable {
    private Coche coche;
    private boolean seguro;
    private boolean aireAcondicionado;
    private boolean gps;
    private boolean radioDVD;
    private String tiempo;
    private String precio;

    public Seleccion() {
        this.coche = null;
        this.seguro = false;
        this.aireAcondicionado = false;
        this.gps = false;
        this.radioDVD = false;
        this.tiempo = "";
        this.precio= "";
    }

    public Seleccion(Coche coche, boolean seguro, boolean aireAcondicionado, boolean gps, boolean radioDVD, String tiempo, String precio) {
        this.coche = coche;
        this.seguro = seguro;
        this.aireAcondicionado = aireAcondicionado;
        this.gps = gps;
        this.radioDVD = radioDVD;
        this.tiempo = tiempo;
        this.precio = precio;

    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isRadioDVD() {
        return radioDVD;
    }

    public void setRadioDVD(boolean radioDVD) {
        this.radioDVD = radioDVD;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTiempo() {

        return tiempo;
    }

    public String getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Seleccion{" +
                "coche=" + coche +
                ", seguro=" + seguro +
                ", aireAcondicionado=" + aireAcondicionado +
                ", gps=" + gps +
                ", radioDVD=" + radioDVD +
                ", tiempo='" + tiempo + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
