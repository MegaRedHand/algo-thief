package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Computadora {

    private final List<Ladron> ladrones;

    public Computadora(List<Ladron> ladrones) {
        this.ladrones = ladrones;
    }

    List<String> ladronesConDescripcion(DescripcionSospechoso descripcion) {
        return ladrones.stream().filter(d -> descripcion.coincideCon(d.descripcion())).map(Ladron::getNombre)
                .collect(Collectors.toList());
    }

    public List<Ladron> listaDeLadrones() {
        return ladrones;
    }
}
