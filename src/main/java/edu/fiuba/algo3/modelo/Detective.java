package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Detective {

    private final Cronometro cronometro;
    private Ciudad ciudadActual;
    private final ContadorDeDificultad contador;
    private final Map<Edificio, Integer> visitasPorEdificio = new HashMap<>();
    private Salud salud = new Saludable();

    public Detective(Cronometro cronometro, Ciudad ciudad, ContadorDeDificultad contador) {
        this.cronometro = cronometro;
        this.ciudadActual = ciudad;
        this.contador = contador;
    }

    private Pista visitar(Edificio edificio) {
        registrarVisita(edificio);
        cronometro.restar(tiempoDeVisita(edificio));
        return edificio.obtenerPista();
    }

    private void registrarVisita(Edificio edificio) {
        int cantidadDeVisitas = visitasPorEdificio.getOrDefault(edificio, 0) + 1;
        visitasPorEdificio.put(edificio, cantidadDeVisitas);
    }

    private int tiempoDeVisita(Edificio edificio) {
        return Integer.min(visitasPorEdificio.getOrDefault(edificio, 0), 3);
    }

    public void viajar(Ciudad ciudad) {
        cronometro.restar(contador.rango().tiempoDeViaje(3800));
        ciudadActual = ciudad;
    }

    public void recibirHeridaDeCuchillo() {
        cronometro.restar(salud.tiempoDeRecuperacion());
        // sería mejor?
        // salud = new Herido();
        salud = salud.recibirHeridaDeCuchillo();
    }

    public void recibirHeridaPorArmaDeFuego() {
        // hay alguna forma de unirlo a Salud?
        cronometro.restar(4);
    }

    public void dormir() {
        cronometro.restar(8);
    }

    public Pista visitar(String nombreEdificio) {
        return this.visitar(ciudadActual.obtenerEdificio(nombreEdificio));
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
