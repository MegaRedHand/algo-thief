package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algothief {

    private final FuenteDeDatos fuente;
    private Escenario escenarioActual;
    private Pista ultimaPista;
    private ContadorDeDificultad contador;
    private final DescripcionSospechoso descripcion = new DescripcionSospechoso();
    private boolean acabado = false;
    private boolean ganado = false;
    private Cronometro cronometro;

    public Algothief(FuenteDeDatos fuente) {
        this.fuente = fuente;
    }

    public void generarEscenario(EscenarioBuilder builder) {
        escenarioActual = builder.construirCon(contador, fuente);
        cronometro = builder.obtenerCronometro();
    }

    public void visitar(String nombreEdificio) {
        ultimaPista = escenarioActual.detectiveVisitar(nombreEdificio);
    }

    public String pistaMasReciente() {
        return ultimaPista.descripcion();
    }

    public void asignarDetective(ContadorDeDificultad contador) {
        this.contador = contador;
    }

    public void viajar(String nombreCiudad) {
        escenarioActual.detectiveViajar(nombreCiudad);
    }

    public void recibirHeridaDeCuchillo() {
        escenarioActual.detectiveRecibirHeridaDeCuchillo();
    }

    public void recibirHeridaPorArmaDeFuego() {
        escenarioActual.detectiveRecibirHeridaPorArmaDeFuego();
    }

    public void dormir() {
        escenarioActual.detectiveDormir();
    }

    public void cargarDatosSospechoso(DescripcionSospechoso descripcion) {
        this.descripcion.agregar(descripcion);
    }

    public List<String> buscarSospechosos() {
        List<String> nombres = fuente.getComputadora().ladronesConDescripcion(descripcion);

        if (nombres.size() == 1) {
            escenarioActual.emitirOrdenDeArresto(nombres.get(0));
        }

        return nombres;
    }

    public void atraparSospechoso() {
        ganado = escenarioActual.detectiveAtraparLadron();
        acabado = true;
    }

    public boolean juegoAcabado() {
        return acabado;
    }

    public boolean juegoGanado() {
        return ganado;
    }

}
