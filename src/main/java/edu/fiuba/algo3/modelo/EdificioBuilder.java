package edu.fiuba.algo3.modelo;

public class EdificioBuilder {

    private final String nombreEdificio;
    private final String tipoEdificio;

    public EdificioBuilder(String nombreEdificio, String tipoEdificio) {
        this.nombreEdificio = nombreEdificio;
        this.tipoEdificio = tipoEdificio;
    }

    public Edificio construirCon(Rango rango, FuenteDeDatos fuente) {
        return new Edificio(nombreEdificio, fuente.obtenerPista(rango.dificultad(), tipoEdificio));
    }

}
