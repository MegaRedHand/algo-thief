package edu.fiuba.algo3.modelo;

public class Algothief {

    private Escenario escenarioActual;
    private Pista ultimaPista;

    public void asignarEscenario(Escenario escenario) {
        escenarioActual = escenario;
    }

    public void visitarEdificio(String nombreEdificio) {
        ultimaPista = escenarioActual.detectiveVisita(nombreEdificio);
    }

    public String pistaMasReciente() {
        return ultimaPista.descripcion();
    }
}
