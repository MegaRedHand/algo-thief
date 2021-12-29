package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class GeneradorDePistasBanco implements GeneradorDePistas {

    private String getPistaMoneda(Map<String, ?> datosCiudad) {
        String templatePista = "La moneda de este país es %s.";
        return String.format(templatePista, datosCiudad.get("moneda").toString());
    }

    private String getPistaIndustria(Map<String, ?> datosCiudad) {
        String templatePista = "La principal actividad económica de este país es %s.";
        return String.format(templatePista, ((List<String>)datosCiudad.get("industrias")).get(0));
    }

    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaMoneda(datosCiudad), descripcion.getPistaVehiculo());
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaMoneda(datosCiudad), descripcion.getPistaVehiculo());
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaIndustria(datosCiudad), descripcion.getPistaColorDePelo());
    }

}
