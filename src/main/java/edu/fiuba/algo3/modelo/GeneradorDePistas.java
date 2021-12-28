package edu.fiuba.algo3.modelo;

import java.util.Map;

public interface GeneradorDePistas {

    Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion);
    Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion);
    Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion);

}
