package edu.fiuba.algo3.modelo;

import java.util.List;

public class Escenario {

    private final Policia policia;
    private final Ladron ladron;
    private final List<Ciudad> ciudades;
    private String nombreEnOrdenDeArresto;

    public Escenario(Policia policia, Ladron ladron, List<Ciudad> ciudades) {
        this.policia = policia;
        this.ladron = ladron;
        this.ciudades = ciudades;
    }

    public Pista policiaVisitar(String nombreEdificio) {
        return policia.visitar(nombreEdificio);
    }

    public void policiaViajar(String nombreCiudad) {
        policia.viajar(ciudades.stream().filter(c -> c.es(nombreCiudad)).findAny().orElseThrow());
    }

    public void policiaRecibirHeridaDeCuchillo() {
        policia.recibirHeridaDeCuchillo();
    }

    public void policiaRecibirHeridaPorArmaDeFuego() {
        policia.recibirHeridaPorArmaDeFuego();
    }

    public void policiaDormir() {
        policia.dormir();
    }

    public boolean policiaAtraparLadron() {
        boolean ganado = ladron.seLlama(nombreEnOrdenDeArresto);
        if (ganado) {
            policia.registrarArresto();
        }
        return ganado;
    }

    public void emitirOrdenDeArresto(String nombre) {
        nombreEnOrdenDeArresto = nombre;
    }

    public List<String> edificiosVisitables() {
        return policia.edificiosVisitables();
    }

    public List<String> ciudadesVisitables() {
        return policia.ciudadesVisitables();
    }

}
