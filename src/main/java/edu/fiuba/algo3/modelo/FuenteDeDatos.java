package edu.fiuba.algo3.modelo;

import java.util.List;

public interface FuenteDeDatos {

    Computadora getComputadora();

    List<Comun> obtenerObjetosComunes();
    List<Valioso> obtenerObjetosValiosos();
    List<MuyValioso> obtenerObjetosMuyValiosos();

    List<CiudadBuilder> crearCiudadBuilders();

}
