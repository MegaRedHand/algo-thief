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

    public CiudadBuilder conEdificios(String... nombresEdificios) {
        // TODO: tal vez conviene encargárselo a otra clase EdificioBuilder?
        Pista pista = new Facil("Descripción de la pista");
        Stream.of(nombresEdificios).forEach(nombre -> edificiosDeLaCiudad.add(new Edificio(nombre, pista)));
        return this;
    }

    public Ciudad construir() {
        // TODO: generar pista (tal vez los builders deberían instanciarse con un GeneradorDePistas)
        return new Ciudad(nombreCiudad, edificiosDeLaCiudad);
    }
}
