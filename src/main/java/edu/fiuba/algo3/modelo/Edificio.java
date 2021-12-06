package edu.fiuba.algo3.modelo;

public class Edificio {
    private String nombre ;
    private Pista pista;

    public Edificio (String nombreEdificio, Pista pistaAsignada){
        this.nombre = nombreEdificio;
        this.pista = pistaAsignada;
    }


    public Pista obtenerPista() {
        return pista;
    }
}
