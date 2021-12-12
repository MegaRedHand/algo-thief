package edu.fiuba.algo3.modelo;

public class Algothief {

    private Escenario escenarioActual;
    private Pista ultimaPista;
    private Rango rango;

    public void generarEscenario(Builder builder) {
        escenarioActual = builder.construirCon(rango);
    }

    public void visitarEdificio(String nombreEdificio) {
        ultimaPista = escenarioActual.detectiveVisita(nombreEdificio);
    }

    public String pistaMasReciente() {
        return ultimaPista.descripcion();
    }

    public void asignarDetective(int cantidadDeArrestos) {
        rango = new Novato();
    }
}
