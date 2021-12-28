package edu.fiuba.algo3.modelo;

import java.util.List;

public interface FuenteDeDatos {

    @Deprecated
    Pista obtenerPista(String dificultad, String tipoEdificio);

    Computadora getComputadora();

    Comun obtenerObjetosComunes();
    Valioso obtenerObjetosValiosos();
    MuyValioso obtenerObjetosMuyValiosos();

    List<CiudadBuilder> crearCiudadBuilders();

}
