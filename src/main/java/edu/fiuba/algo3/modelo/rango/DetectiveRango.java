package edu.fiuba.algo3.modelo.rango;

public class DetectiveRango extends RangoLineal {

    public DetectiveRango() {
        super(10, 1100);
    }

    @Override
    Rango siguiente() {
        return new Investigador();
    }

}
