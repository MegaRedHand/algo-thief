package edu.fiuba.algo3.modelo.rango;

public class Novato extends RangoLineal {


    public Novato() {
        super(5, 900);
    }

    Rango siguiente() {
        return new DetectiveRango();
    }

}
