package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public class Detective {  // TODO: cambiar nombre a Policía (hay un rango Detective)

    private final Cronometro cronometro;
    private Ciudad ciudadActual;
    private final ContadorDeDificultad contador;
    private final Map<Edificio, Integer> visitasPorEdificio = new HashMap<>();
    private int cantidadDeHeridasDeCuchillo = 0;

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
        if (cantidadDeHeridasDeCuchillo == 0) {
            cronometro.restar(2);
        } else {
            cronometro.restar(1);
        }
        ++cantidadDeHeridasDeCuchillo;
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

}
