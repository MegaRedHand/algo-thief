package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

    private List<Banco> edificios = new ArrayList<>();
    private String nombre;

    public Ciudad(String nombre, Banco banco) {

        this.nombre = nombre;
        this.edificios.add(banco);
    }

    /*
    public void visitarEdificio (String nombreEdificio) {
        Edificio edificio = self.buscarEdificio(nombreEdificio);
        edificio.visitar();
    }

     */
}
