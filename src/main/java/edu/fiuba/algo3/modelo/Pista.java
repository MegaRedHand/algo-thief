package edu.fiuba.algo3.modelo;

public class Pista {

    private final String descripcion;

    public Pista(String... descripciones) {
        this.descripcion = String.join(" ", descripciones);
    }

    public String descripcion() {
        return descripcion;
    }

}