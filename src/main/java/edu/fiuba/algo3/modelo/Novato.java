package edu.fiuba.algo3.modelo;

import java.util.Map;

public class Novato extends RangoLineal {


    public Novato() {
        super(5, 900);
    }

    Rango siguiente() {
        return new Detective();
    }

    @Override
    public Pista generarPistaCon(GeneradorDePistas generador, Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        // TODO: agregar en supuestos
        return generador.generarPistaFacil(datosCiudad, descripcion);
    }

}
