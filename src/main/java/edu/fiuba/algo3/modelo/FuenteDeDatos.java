package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public interface FuenteDeDatos {

    @Deprecated
    Pista obtenerPista(String dificultad, String tipoEdificio);

    Computadora getComputadora();

    List<CiudadBuilder> crearCiudadesBuilder(String rutaArchivo);

    List<ObjetoRobado> obtenerListadoDeObjetos();

}
