package edu.fiuba.algo3.modelo;

public class BibliotecaBuilder extends EdificioBuilder {

    public BibliotecaBuilder() {
        super("Biblioteca");
    }

    @Override
    protected GeneradorDePistas crearGeneradorDePistas() {
        // TODO: implementar generadores de pistas para Biblioteca, Puerto, y Aeropuerto
        return new GeneradorDePistasBanco();
    }

}
