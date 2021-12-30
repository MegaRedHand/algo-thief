package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Policia {

    private final Cronometro cronometro;
    private Ciudad ciudadActual;
    private final ContadorDeDificultad contador;
    private Salud salud = new Saludable();

    public Policia(Cronometro cronometro, Ciudad ciudad, ContadorDeDificultad contador) {
        this.cronometro = cronometro;
        this.ciudadActual = ciudad;
        this.contador = contador;
    }

    public void viajar(Ciudad ciudadDestino) {
        cronometro.registrarViaje(contador.rango(), ciudadActual, ciudadDestino);
        ciudadActual = ciudadDestino;
    }

    public void recibirHeridaDeCuchillo() {
        cronometro.registrarHeridaDeCuchillo(salud);
        // TODO: sería mejor?
        //  salud = new Herido();
        salud = salud.recibirHeridaDeCuchillo();
    }

    public void recibirHeridaPorArmaDeFuego() {
        // TODO: hay alguna forma de unirlo a Salud?
        cronometro.registrarHeridaPorArmaDeFuego();
    }

    public void dormir() {
        cronometro.registrarDormir();
    }

    public Pista visitar(String nombreEdificio) {
        return this.visitar(ciudadActual.obtenerEdificio(nombreEdificio));
    }

    private Pista visitar(Edificio edificio) {
        cronometro.registrarVisita(edificio);
        return edificio.obtenerPista();
    }

    public void registrarArresto() {
        contador.registrarArresto();
    }

    public List<String> edificiosVisitables() {
        return ciudadActual.edificiosVisitables();
    }

    public List<String> ciudadesVisitables() {
        return ciudadActual.ciudadesVisitables();
    }

}
