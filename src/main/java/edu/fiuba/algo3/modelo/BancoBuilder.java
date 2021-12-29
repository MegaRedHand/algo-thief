package edu.fiuba.algo3.modelo;

public class BancoBuilder extends EdificioBuilder {

    public BancoBuilder() {
        super("Banco");
    }

    @Override
    protected GeneradorDePistas crearGeneradorDePistas() {
        return new GeneradorDePistasBanco();
    }

}
