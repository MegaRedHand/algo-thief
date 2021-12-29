package edu.fiuba.algo3.modelo;

import java.util.Map;

public class GeneradorDePistasBanco implements GeneradorDePistas {

    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        String templatePista = "La moneda de este país es %s. El ladrón se fue en un %s.";
        return new Pista(String.format(templatePista, datosCiudad.get("moneda").toString(), descripcion.getVehiculo()));
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista("Esta es una pista media");
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista("Esta es una pista dificil");
    }

}
