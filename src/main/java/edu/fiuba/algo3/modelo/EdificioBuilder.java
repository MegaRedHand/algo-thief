package edu.fiuba.algo3.modelo;

import java.util.Map;

public abstract class EdificioBuilder {

    private final String nombreEdificio;
    private String nombreCiudad;

    protected EdificioBuilder(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public void deCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    private GeneradorDePistas getGeneradorDePistas(Map<String, ?> datosSiguienteCiudad) {
        if (datosSiguienteCiudad == null) {
            return new GeneradorDePistasSinLadron();
        }
        return crearGeneradorDePistas();
    }

    protected abstract GeneradorDePistas crearGeneradorDePistas();

    public Edificio construirCon(Rango rango, Map<String, ?> datosSiguienteCiudad, DescripcionSospechoso descripcion) {
        String nombre = String.format("%s de %s", nombreEdificio, nombreCiudad);
        return new Edificio(nombre, rango.generarPistaCon(getGeneradorDePistas(datosSiguienteCiudad), datosSiguienteCiudad, descripcion));
    }

}
