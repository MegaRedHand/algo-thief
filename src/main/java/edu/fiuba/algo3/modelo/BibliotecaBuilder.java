package edu.fiuba.algo3.modelo;

public class BibliotecaBuilder extends EdificioBuilder {

    public BibliotecaBuilder() {
        super("Biblioteca");
    }

    @Override
    protected GeneradorDePistas crearGeneradorDePistas() {
        return new GeneradorDePistasBanco();
    }

}
