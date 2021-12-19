package edu.fiuba.algo3.modelo;

public class DetectiveRango extends RangoLineal {

    public DetectiveRango() {
        super(10, 1100, "facil");
    }

    @Override
    Rango siguiente() {
        return new Investigador();
    }

}
