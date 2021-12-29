package edu.fiuba.algo3.modelo;

import java.util.Map;

public class GeneradorDePistasSinLadron implements GeneradorDePistas {
    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista("El ladrón no pasó por aquí");
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista("El ladrón no pasó por aquí");
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista("El ladrón no pasó por aquí");
    }
}
