package edu.fiuba.algo3.modelo;

import java.util.Map;

public class Detective extends RangoLineal {

    public Detective() {
        super(10, 1100);
    }

    @Override
    Rango siguiente() {
        return new Investigador();
    }

    @Override
    public Pista generarPistaCon(GeneradorDePistas generador, Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return generador.generarPistaFacil(datosCiudad, descripcion);
    }

}
