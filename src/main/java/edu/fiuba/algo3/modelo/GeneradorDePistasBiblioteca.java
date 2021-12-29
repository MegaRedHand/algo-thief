package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class GeneradorDePistasBiblioteca implements GeneradorDePistas{
    private String getPistaGeografia(Map<String, ?> datosCiudad) {
        String templatePista = "La geografia de este país es %s.";
        return String.format(templatePista, datosCiudad.get("geografia").toString());
    }

    private String getPistaCaracteristicas(Map<String, ?> datosCiudad) {
        String templatePista = "Una caracteristica de este país es %s.";
        return String.format(templatePista, ((List<String>)datosCiudad.get("caracteristicas")).get(0));
    }

    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaGeografia(datosCiudad), descripcion.getPistaVehiculo()));
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaGeografia(datosCiudad), descripcion.getPistaVehiculo()));
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(String.format("%s %s", getPistaCaracteristicas(datosCiudad), descripcion.getPistaVehiculo()));
    }
}
