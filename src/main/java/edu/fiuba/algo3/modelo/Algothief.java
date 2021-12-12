package edu.fiuba.algo3.modelo;

public class Algothief {

    private Escenario escenarioActual;
    private Pista ultimaPista;
    private ContadorDeDificultad contador;

    public void generarEscenario(Builder builder) {
        escenarioActual = builder.construirCon(contador);
    }

    public void visitarEdificio(String nombreEdificio) {
        ultimaPista = escenarioActual.detectiveVisita(nombreEdificio);
    }

    public String pistaMasReciente() {
        return ultimaPista.descripcion();
    }

    public void asignarDetective(ContadorDeDificultad contador) {
        this.contador = contador;
    }
}
