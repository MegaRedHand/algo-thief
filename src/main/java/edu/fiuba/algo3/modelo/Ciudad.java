package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

    private List<Edificio> edificios = new ArrayList<>();
    private String nombre;

    public Ciudad(String nombre, List<Edificio> edificiosRecibidos ) {

        this.nombre = nombre;
        this.edificios = edificiosRecibidos;
    }

    /*
    public void visitarEdificio (String nombreEdificio) {
        Edificio edificio = self.buscarEdificio(nombreEdificio);
        edificio.visitar();
    }

     */
}
