package edu.fiuba.algo3.modelo;

import java.util.Collections;
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
        if (ciudadActual.esCiudadFinal()) {
            List<String> nombresEdificios = edificiosVisitables();
            Collections.shuffle(nombresEdificios);
            if (nombresEdificios.get(0).equals(nombreEdificio)) {
                return new Pista("Lograste atrapar al ladrón.");
            } else if (nombresEdificios.get(1).equals(nombreEdificio)) {
                recibirHeridaDeCuchillo();
                return new Pista("Recibiste una herida de cuchillo.");
            } else {
                recibirHeridaPorArmaDeFuego();
                return new Pista("Recibiste una herida por arma de fuego.");
            }
        }
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
