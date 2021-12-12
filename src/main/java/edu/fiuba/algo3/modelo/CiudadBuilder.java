package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CiudadBuilder {

    private final String nombreCiudad;
    private final List<Edificio> edificiosDeLaCiudad = new ArrayList<>();


    public CiudadBuilder(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public CiudadBuilder yEdificios(String... nombresEdificios) {
        Pista pista = new Facil("Descripción de la pista");
        Stream.of(nombresEdificios).forEach(nombre -> edificiosDeLaCiudad.add(new Edificio(nombre, pista)));
        return this;
    }

    public Ciudad construir() {
        // TODO: generar pista
        return new Ciudad(nombreCiudad, edificiosDeLaCiudad);
    }
}
