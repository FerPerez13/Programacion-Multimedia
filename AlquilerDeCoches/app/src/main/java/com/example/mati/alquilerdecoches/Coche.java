package com.example.mati.alquilerdecoches;

import java.io.Serializable;

/**
 * Created by mati on 21/11/16.
 */
public class Coche implements Serializable {

    private String modelo;
    private String marca;
    private String precio;
    private int img;

    public Coche(String modelo, String marca, String precio, int img) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.img = img;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPrecio() {
        return precio;
    }

    public int getImg() {
        return img;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
