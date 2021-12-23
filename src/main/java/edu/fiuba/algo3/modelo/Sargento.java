package edu.fiuba.algo3.modelo;

public class Sargento extends RangoLineal {

    public Sargento() {
        super(20, 1500, "dificil");
    }

    @Override
    Rango siguiente() {
        return this;
    }

}
