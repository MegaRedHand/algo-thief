package edu.fiuba.algo3.modelo;

public class Ladron {

    private final String nombre;
    private final DescripcionSospechoso descripcion;


    public Ladron(String nombre, DescripcionSospechoso descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public DescripcionSospechoso descripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean seLlama(String nombre) {
        return this.nombre.equals(nombre);
    }
}