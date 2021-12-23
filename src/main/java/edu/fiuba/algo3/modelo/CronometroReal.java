package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CronometroReal {

    private static final int LIMITE_DE_TIEMPO = 6 /*dias*/ * 24 /*horas*/ + 17 /*horas*/;
    private final Map<Edificio, Integer> visitasPorEdificio = new HashMap<>();
    private int tiempoRegistrado = 7; // porque empieza el lunes a las 7

    public void registrarVisita(Edificio edificio) {
        int cantidadDeVisitas = visitasPorEdificio.getOrDefault(edificio, 0) + 1;
        tiempoRegistrado += Integer.min(cantidadDeVisitas, 3);
        visitasPorEdificio.put(edificio, cantidadDeVisitas);
    }

    public void registrarViaje(Rango rango, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        tiempoRegistrado += rango.tiempoDeViaje(4); // ciudadOrigen.distanciaA(ciudadDestino));
    }

    public void registrarDormir() {
        tiempoRegistrado += 8;
    }

    public void registrarHeridaDeCuchillo(Salud salud) {
        tiempoRegistrado += salud.tiempoDeRecuperacion();
    }

    public void registrarHeridaPorArmaDeFuego() {
        tiempoRegistrado += 4;
    }

    public String fechaActual() {
        int horas = tiempoRegistrado % 24;
        int dias = tiempoRegistrado / 24;
        // el 6 de diciembre del 2021 fue lunes
        LocalDateTime fecha = LocalDateTime.of(2021, Month.DECEMBER, 6 + dias, horas, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E H:m"); // "Lunes 16:00"
        return fecha.format(formatter);
    }

    public boolean seAcaboElTiempo() {
        // la alternativa es llamar a un método que levante una excepción cuando se acabó el tiempo
        return tiempoRegistrado >= LIMITE_DE_TIEMPO;
    }

}
