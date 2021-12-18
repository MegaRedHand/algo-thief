package edu.fiuba.algo3.modelo.rango;

public class Investigador extends RangoLineal {

    public Investigador() {
        super(20, 1300);
    }

    @Override
    Rango siguiente() {
        return new Sargento();
    }

}