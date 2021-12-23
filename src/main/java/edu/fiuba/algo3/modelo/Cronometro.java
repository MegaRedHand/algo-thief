package edu.fiuba.algo3.modelo;

public class Cronometro {

    private int horas = 0;

    void restar(int horas) {
        this.horas += horas;
    }

    public int tiempo() {
        return this.horas;
    }

}
