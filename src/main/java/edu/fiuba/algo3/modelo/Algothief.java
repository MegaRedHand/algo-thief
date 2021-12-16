package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algothief {

    private final FuenteDeDatos fuente;
    private Escenario escenarioActual;
    private Pista ultimaPista;
    private ContadorDeDificultad contador;
    private DescripcionSospechoso descripcion = new DescripcionSospechoso();

    public Algothief(FuenteDeDatos fuente) {
        this.fuente = fuente;
    }

    public void generarEscenario(Builder builder) {
        escenarioActual = builder.construirCon(contador);
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

    public void dormir() {
        escenarioActual.detectiveDormir();
    }

    public void cargarDatosSospechoso(DescripcionSospechoso descripcion) {
        this.descripcion.agregar(descripcion);
    }

    public List<String> buscarSospechosos() {
//        List<DescripcionSospechoso> sospechosos = fuente.listaDeSospechosos();
        List<DescripcionSospechoso> sospechosos = new ArrayList<>();
        sospechosos.add(new DescripcionSospechoso().conNombre("Carmen SanDiego").conSexo("Femenino").conHobby("Tenis"));
        return sospechosos.stream().filter(d -> this.descripcion.coincideCon(d)).map(DescripcionSospechoso::nombre)
                .collect(Collectors.toList());
    }

    public void atraparSospechoso() {
    }

    public boolean juegoAcabado() {
        return true;
    }

    public boolean juegoGanado() {
        return false;
    }
}
