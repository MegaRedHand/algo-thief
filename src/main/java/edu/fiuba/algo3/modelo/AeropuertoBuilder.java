package edu.fiuba.algo3.modelo;

public class AeropuertoBuilder extends EdificioBuilder {

    public AeropuertoBuilder() {
        super("Aeropuerto");
    }

    @Override
    protected GeneradorDePistas crearGeneradorDePistas() {
        return new GeneradorDePistasBanco();
    }

}
