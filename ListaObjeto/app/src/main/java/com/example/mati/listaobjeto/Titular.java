package com.example.mati.listaobjeto;

/**
 * Created by mati on 19/10/16.
 */
public class Titular {

    private String titulo;
    private String subtitulo;

    public Titular(String subtitulo, String titulo) {
        this.subtitulo = subtitulo;
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
}
