package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class CiudadBuilder {

    private final String nombreCiudad;
    private final List<Edificio> edificiosDeLaCiudad = new ArrayList<>();


    public CiudadBuilder(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public CiudadBuilder yEdificios(String nombreEdificio) {
        Pista pista = new Facil("Descripción de la pista");
        edificiosDeLaCiudad.add(new Edificio(nombreEdificio, pista));
        return this;
    }

    public Ciudad construir() {
        // TODO: generar pista
        return new Ciudad(nombreCiudad, edificiosDeLaCiudad);
    }
}
