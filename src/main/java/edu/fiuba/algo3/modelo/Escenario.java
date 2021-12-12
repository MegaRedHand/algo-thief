package edu.fiuba.algo3.modelo;

import java.util.List;

public class Escenario {
    private final Detective detective;
    private final Ladron ladron;
    private final List<Ciudad> rutaDeEscape;

    public Escenario(Detective detective, Ladron ladron, List<Ciudad> rutaDeEscape) {
        this.detective = detective;
        this.ladron = ladron;
        this.rutaDeEscape = rutaDeEscape;
    }

    public Pista detectiveVisita(String nombreEdificio) {
        return detective.visitar(nombreEdificio);
    }
}
