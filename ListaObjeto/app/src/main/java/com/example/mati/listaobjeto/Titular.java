package com.example.mati.listaobjeto;

import android.media.Image;

/**
 * Created by mati on 19/10/16.
 */
public class Titular {

    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String subtitulo, String titulo, int imagen) {
        this.subtitulo = subtitulo;
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setImagen(int imagen) { this.imagen = imagen; }

    public int getImagen() { return imagen;}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
}
