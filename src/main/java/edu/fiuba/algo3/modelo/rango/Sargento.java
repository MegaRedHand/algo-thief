package edu.fiuba.algo3.modelo.rango;

public class Sargento extends RangoLineal {

    public Sargento() {
        super(20, 1500);
    }

    @Override
    Rango siguiente() {
        return this;
    }

}
