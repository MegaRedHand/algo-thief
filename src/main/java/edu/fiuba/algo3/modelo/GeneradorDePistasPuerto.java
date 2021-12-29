package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class GeneradorDePistasPuerto implements GeneradorDePistas{

    private String getPistaColorBandera(Map<String, ?> datosCiudad) {
        String colores = String.join(", ", (List<String>)datosCiudad.get("colorBandera"));
        return String.format("El sospechoso se fue en un barco con una bandera color %s.", colores);
    }

    private String getPistaEtnias(Map<String, ?> datosCiudad) {
        String templatePista = "El sospechoso estaba hablando con un marinero %s.";
        return String.format(templatePista, ((List<String>)datosCiudad.get("etnias")).get(0));
    }

    @Override
    public Pista generarPistaFacil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaColorBandera(datosCiudad), descripcion.getPistaOcupacion());
    }

    @Override
    public Pista generarPistaMedia(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaColorBandera(datosCiudad), descripcion.getPistaOcupacion());
    }

    @Override
    public Pista generarPistaDificil(Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return new Pista(getPistaEtnias(datosCiudad), descripcion.getPistaOcupacion());
    }
}
