package edu.fiuba.algo3.modelo;

public class PuertoBuilder extends EdificioBuilder {

    public PuertoBuilder() {
        super("Puerto");
    }

    @Override
    protected GeneradorDePistas crearGeneradorDePistas() {
        return new GeneradorDePistasPuerto();
    }

}
