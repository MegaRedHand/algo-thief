package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public class Detective {
    private final Cronometro cronometro;
    private Ciudad ciudadActual;
    private Rango rango;
    private final Map<Edificio, Integer> visitasPorEdificio = new HashMap<>();

    public Detective(Cronometro cronometro, Ciudad ciudad, Rango rango) {
        this.cronometro = cronometro;
        this.ciudadActual = ciudad;
        this.rango = rango;
    }

    public Pista visitar(Edificio edificio) {

        int cantidadDeVisitas = visitasPorEdificio.getOrDefault(edificio, 0) + 1;
        visitasPorEdificio.put(edificio, cantidadDeVisitas);
        int horas = Integer.min(cantidadDeVisitas, 3);
        cronometro.restar(horas);
        return edificio.obtenerPista();
    }

    public void viajar(Ciudad ciudad) {
        cronometro.restar(8);
        ciudadActual = ciudad;
    }
}
