package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Cronometro {

    private final static int LIMITE_DE_TIEMPO = 6 /*dias*/ * 24 /*horas*/ + 17 /*horas*/;
    private final Map<Edificio, Integer> visitasPorEdificio = new HashMap<>();
    private int tiempoRegistrado = 0; // porque empieza el lunes a las 7
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E H:m"); // "Lunes 16:00"
    // fecha.format(FORMATTER);

    /**
     * El cronómetro inicia a las 0 hs del lunes + la cantidad de horas que indica tiempoInicial
     * @param tiempoInicial la cantidad de horas que se le adicionan al cronometro inicialmente
     */
    public Cronometro(int tiempoInicial) {
        this.restar(tiempoInicial);
    }

    private void restar(int horasPasadas) {
        tiempoRegistrado += horasPasadas;
    }

    public void registrarVisita(Edificio edificio) {
        int cantidadDeVisitas = visitasPorEdificio.getOrDefault(edificio, 0) + 1;
        this.restar(Integer.min(cantidadDeVisitas, 3));
        visitasPorEdificio.put(edificio, cantidadDeVisitas);
    }

    public void registrarViaje(Rango rango, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.restar(rango.tiempoDeViaje(ciudadOrigen.distanciaA(ciudadDestino)));
    }

    public void registrarDormir() {
        this.restar(8);
    }

    public void registrarHeridaDeCuchillo(Salud salud) {
        this.restar(salud.tiempoDeRecuperacion());
    }

    public void registrarHeridaPorArmaDeFuego() {
        this.restar(4);
    }

    public LocalDateTime fechaActual() {
        // el 6 de diciembre del 2021 fue lunes
        LocalDateTime fecha = LocalDateTime.of(2021, Month.DECEMBER, 6, 0, 0);
        return fecha.plusHours(tiempoRegistrado);
    }

    public boolean seAcaboElTiempo() {
        // la alternativa es llamar a un método que levante una excepción cuando se acabó el tiempo
        return tiempoRegistrado >= LIMITE_DE_TIEMPO;
    }

    public void registrarEmisionDeOrdenDeArresto() {
        restar(3);
    }
}
