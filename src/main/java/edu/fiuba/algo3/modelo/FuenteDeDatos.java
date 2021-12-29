package edu.fiuba.algo3.modelo;

import java.util.List;

public interface FuenteDeDatos {

    @Deprecated
    Pista obtenerPista(String dificultad, String tipoEdificio);

    Computadora getComputadora();

    List<Comun> obtenerObjetosComunes();
    List<Valioso> obtenerObjetosValiosos();
    List<MuyValioso> obtenerObjetosMuyValiosos();

    List<CiudadBuilder> crearCiudadBuilders();

}
