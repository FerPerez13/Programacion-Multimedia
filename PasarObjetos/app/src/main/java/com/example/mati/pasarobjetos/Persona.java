package com.example.mati.pasarobjetos;

/**
 * Created by mati on 5/10/16.
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    //private int imagen;

    public Persona(){
        this.nombre="Empty";
        this.apellidos="Empty";
        this.edad=0;
    }
    public Persona(String nombre, String apellidos, int edad){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getApellidos() {
        return apellidos;
    }
    /*public int getImagen() {
        return imagen;
    }*/

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) { this.edad = edad; }

    /*public void setImagen(int imagen) {
        this.imagen = imagen;
    }*/

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }
}
