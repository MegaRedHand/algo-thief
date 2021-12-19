package edu.fiuba.algo3.modelo;

import java.util.List;

public interface FuenteDeDatos {

    List<Ladron> listaDeLadrones();

    Pista obtenerPista(String dificultad, String tipoEdificio);

}
