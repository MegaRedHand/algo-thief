package edu.fiuba.algo3.modelo;

import java.util.Map;

public class Sargento extends RangoLineal {

    public Sargento() {
        super(20, 1500);
    }

    @Override
    Rango siguiente() {
        return this;
    }

    @Override
    public Pista generarPistaCon(GeneradorDePistas generador, Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return generador.generarPistaDificil(datosCiudad, descripcion);
    }

}
