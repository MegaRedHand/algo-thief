package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.Computadora;
import edu.fiuba.algo3.modelo.FuenteDeDatos;
import edu.fiuba.algo3.modelo.Pista;

public class LectorDeArchivos implements FuenteDeDatos {

    @Override
    public Pista obtenerPista(String dificultad, String tipoEdificio) {
        return new Pista("");
    }

    @Override
    public Computadora getComputadora() {
        return null;
    }

}
