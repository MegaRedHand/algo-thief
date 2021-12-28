package edu.fiuba.algo3.modelo;

import java.util.Map;

public class Investigador extends RangoLineal {

    public Investigador() {
        super(20, 1300, "media");
    }

    @Override
    Rango siguiente() {
        return new Sargento();
    }

    @Override
    public Pista generarPistaCon(GeneradorDePistas generador, Map<String, ?> datosCiudad, DescripcionSospechoso descripcion) {
        return generador.generarPistaMedia(datosCiudad, descripcion);
    }

}