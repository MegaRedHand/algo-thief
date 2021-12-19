package edu.fiuba.algo3.modelo;

public class Novato extends RangoLineal {


    public Novato() {
        super(5, 900, "facil");
    }

    Rango siguiente() {
        return new DetectiveRango();
    }

}
