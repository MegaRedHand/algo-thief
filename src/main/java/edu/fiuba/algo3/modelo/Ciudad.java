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

    /*
    public void visitarEdificio (String nombreEdificio) {
        Edificio edificio = self.buscarEdificio(nombreEdificio);
        edificio.visitar();
    }

     */
}
