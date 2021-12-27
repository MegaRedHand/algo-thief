package edu.fiuba.algo3.modelo;

import java.util.List;

public class Escenario {

    private final Detective detective;
    private final Ladron ladron;
    private final List<Ciudad> ciudades;
    private String nombreEnOrdenDeArresto;

    public Escenario(Detective detective, Ladron ladron, List<Ciudad> ciudades) {
        this.detective = detective;
        this.ladron = ladron;
        this.ciudades = ciudades;
    }

    public Pista detectiveVisitar(String nombreEdificio) {
        return detective.visitar(nombreEdificio);
    }

    public void detectiveViajar(String nombreCiudad) {
        detective.viajar(ciudades.stream().filter(c -> c.es(nombreCiudad)).findAny().orElseThrow());
    }

    public void detectiveRecibirHeridaDeCuchillo() {
        detective.recibirHeridaDeCuchillo();
    }

    public void detectiveRecibirHeridaPorArmaDeFuego() {
        detective.recibirHeridaPorArmaDeFuego();
    }

    public void detectiveDormir() {
        detective.dormir();
    }

    public boolean detectiveAtraparLadron() {
        return ladron.seLlama(nombreEnOrdenDeArresto);
    }

    public void emitirOrdenDeArresto(String nombre) {
        nombreEnOrdenDeArresto = nombre;
    }

    public List<String> edificiosVisitables() {
        return detective.edificiosVisitables();
    }

    public List<String> ciudadesVisitables() {
        return detective.ciudadesVisitables();
    }

}
