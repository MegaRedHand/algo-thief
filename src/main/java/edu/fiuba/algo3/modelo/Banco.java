package edu.fiuba.algo3.modelo;

public class Banco {

    private String nombre ;
    private Pista pista;

    public Banco (String nombreEdificio, Pista pistaAsignada){
        this.nombre = nombreEdificio;
        this.pista = pistaAsignada;
    }


    public Pista obtenerPista() {
        return pista;
    }
}
