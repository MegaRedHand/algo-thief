package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class GeneradorDePistasAeropuerto implements GeneradorDePistas {



    private String getPistaIdioma(Map<String, ?> datosCiudad) {
        String templatePista = "El sospechoso estaba hablando con alguien en %s.";
        return String.format(templatePista, ((List<String>)datosCiudad.get("idiomas")).get(0));
    }

    private String getPistaRepresentante(Map<String, ?> datosCiudad) {
        String templatePista = "El sospechoso estaba escuchando a otro viajero quejándose del %s de su país.";
        return String.format(templatePista, (datosCiudad.get("representante")).toString());
    }

    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaIdioma(datosCiudad), descripcion.getPistaHobby());
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaIdioma(datosCiudad), descripcion.getPistaHobby());
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaRepresentante(datosCiudad), descripcion.getPistaHobby());
    }

}
