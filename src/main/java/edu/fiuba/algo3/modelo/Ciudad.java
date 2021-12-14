package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

    private final String nombre;
    private final List<Edificio> edificios;

    public Ciudad(String nombre, Edificio... edificios) {

        this.nombre = nombre;
        this.edificios = new ArrayList<>(List.of(edificios));
    }

    public Ciudad(String nombre, List<Edificio> edificios) {

        this.nombre = nombre;
        this.edificios = new ArrayList<>(edificios);
    }

    public Edificio obtenerEdificio(String nombreEdificio) {
        return edificios.stream().filter(e -> e.es(nombreEdificio)).findAny().orElseThrow();
    }

    public boolean es(String nombreCiudad) {
        return nombre.equals(nombreCiudad);
    }
}
