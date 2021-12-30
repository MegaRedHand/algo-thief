package edu.fiuba.algo3.modelo;

import java.util.List;

public class Algothief {

    private final FuenteDeDatos fuente;
    private Escenario escenarioActual;
    private Pista ultimaPista;
    private ContadorDeDificultad contador;
    private DescripcionSospechoso descripcion = new DescripcionSospechoso();
    private boolean acabado = false;
    private boolean ganado = false;
    private Cronometro cronometro;

    public Algothief(FuenteDeDatos fuente) {
        this.fuente = fuente;
    }

    public void asignarPolicia(ContadorDeDificultad contador) {
        this.contador = contador;
    }

    public void generarEscenario(EscenarioBuilder builder) {
        escenarioActual = builder.construirCon(contador, fuente);
        cronometro = builder.obtenerCronometro();
    }

    public void visitar(String nombreEdificio) {
        ultimaPista = escenarioActual.policiaVisitar(nombreEdificio);
    }

    public String pistaMasReciente() {
        return ultimaPista.descripcion();
    }

    public void viajar(String nombreCiudad) {
        escenarioActual.policiaViajar(nombreCiudad);
    }

    public void recibirHeridaDeCuchillo() {
        escenarioActual.policiaRecibirHeridaDeCuchillo();
    }

    public void recibirHeridaPorArmaDeFuego() {
        escenarioActual.policiaRecibirHeridaPorArmaDeFuego();
    }

    public void dormir() {
        escenarioActual.policiaDormir();
    }

    public void cargarDatosSospechoso(DescripcionSospechoso descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> buscarSospechosos() {
        return fuente.getComputadora().ladronesConDescripcion(descripcion);
    }

    public void emitirOrdenDeArresto(String nombre) {
        escenarioActual.emitirOrdenDeArresto(nombre);
    }

    public void atraparSospechoso() {
        ganado = escenarioActual.policiaAtraparLadron();
        acabado = true;
    }

    public boolean juegoAcabado() {
        return acabado || cronometro.seAcaboElTiempo();
    }

    public boolean juegoGanado() {
        return ganado;
    }

}
