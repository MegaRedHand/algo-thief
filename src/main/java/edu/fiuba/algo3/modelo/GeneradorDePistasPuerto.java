package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class GeneradorDePistasPuerto implements GeneradorDePistas{

    private String getPistaColorBandera(Map<String, ?> datosCiudad) {
        String templatePista = "El color de la bandera de este país es %s.";
        return String.format(templatePista, ((List<String>)datosCiudad.get("colorBandera")).get(0));
    }

    private String getPistaEtnias(Map<String, ?> datosCiudad) {
        String templatePista = "La etinia de este país es %s.";
        return String.format(templatePista, ((List<String>)datosCiudad.get("etnias")).get(0));
    }

    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaColorBandera(datosCiudad), descripcion.getPistaVehiculo()));
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaColorBandera(datosCiudad), descripcion.getPistaVehiculo()));
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaEtnias(datosCiudad), descripcion.getPistaVehiculo()));
    }
}
