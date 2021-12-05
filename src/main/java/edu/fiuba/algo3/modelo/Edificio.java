package edu.fiuba.algo3.modelo;

public class Edificio {
    private Testigo testigo;

    public Edificio(Testigo testigo) {
        this.testigo = testigo;
    }

    public void visitar() {
        testigo.desplegarPista();
    }
}
