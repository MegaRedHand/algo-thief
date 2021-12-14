package edu.fiuba.algo3.modelo;

public class Algothief {

    private Escenario escenarioActual;
    private Pista ultimaPista;
    private ContadorDeDificultad contador;

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
}
