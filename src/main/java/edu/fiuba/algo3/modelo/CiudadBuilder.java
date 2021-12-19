package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CiudadBuilder {

    private final String nombreCiudad;
    private final List<Edificio> edificiosDeLaCiudad = new ArrayList<>();
    private final List<EdificioBuilder> edificioBuilders = new ArrayList<>();


    public CiudadBuilder(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public CiudadBuilder conEdificios(EdificioBuilder... builders) {
        edificioBuilders.addAll(List.of(builders));
        return this;
    }

    public Ciudad construirCon(Rango rango, FuenteDeDatos fuente) {
        List<Edificio> edificiosDeLaCiudad = edificioBuilders.stream().map(b -> b.construirCon(rango, fuente))
                .collect(Collectors.toList());
        return new Ciudad(nombreCiudad, edificiosDeLaCiudad);
    }

}
