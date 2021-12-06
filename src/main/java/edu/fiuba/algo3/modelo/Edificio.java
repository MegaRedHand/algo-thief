package edu.fiuba.algo3.modelo;

public class Edificio {
    private final String nombre ;
    private final Pista pista;

    public Edificio (String nombre, Pista pista) {
        this.nombre = nombre;
        this.pista = pista;
    }


    public Pista obtenerPista() {
        return pista;
    }
}
