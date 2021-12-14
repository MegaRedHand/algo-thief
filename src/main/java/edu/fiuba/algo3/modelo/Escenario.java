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

    public Pista detectiveVisitar(String nombreEdificio) {
        return detective.visitar(nombreEdificio);
    }

    public void detectiveViajar(String nombreCiudad) {
        detective.viajar(rutaDeEscape.stream().filter(c -> c.es(nombreCiudad)).findAny().orElseThrow());
    }

    public void detectiveRecibirHeridaDeCuchillo() {
        detective.recibirHeridaDeCuchillo();
    }

    public void detectiveDormir() {
        detective.dormir();
    }
}
