package edu.fiuba.algo3.modelo;

import java.util.Map;

public class Novato extends RangoLineal {


    public Novato() {
        super(5, 900, "facil");
    }

    Rango siguiente() {
        return new DetectiveRango();
    }

    @Override
    public Pista generarPistaCon(GeneradorDePistas generador, Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return generador.generarPistaFacil(datosCiudad, descripcion);
    }

}
