package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class GeneradorDePistasAeropuerto implements GeneradorDePistas {



    private String getPistaIdioma(Map<String, ?> datosCiudad) {
        String templatePista = "El idioma de este país es %s.";
        return String.format(templatePista, ((List<String>)datosCiudad.get("idioma")).get(0));
    }

    private String getPistaRepresentante(Map<String, ?> datosCiudad) {
        String templatePista = "El representante de este país es %s.";
        return String.format(templatePista, (datosCiudad.get("representante")).toString());
    }

    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaIdioma(datosCiudad), descripcion.getPistaVehiculo()));
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaIdioma(datosCiudad), descripcion.getPistaVehiculo()));
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaRepresentante(datosCiudad), descripcion.getPistaVehiculo()));
    }

}
