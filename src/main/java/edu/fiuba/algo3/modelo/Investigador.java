package edu.fiuba.algo3.modelo;

public class Investigador extends RangoLineal {

    public Investigador() {
        super(20, 1300, "media");
    }

    @Override
    Rango siguiente() {
        return new Sargento();
    }

}