package edu.fiuba.algo3.modelo;

import java.util.Objects;

public abstract class ObjetoRobado {

    protected final String nombre;
    private final String nombreCiudadOrigen;
    private final int largoDeLaRutaDeEscape;

    protected ObjetoRobado(String nombre, String nombreCiudadOrigen, int largoDeLaRutaDeEscape) {
        this.nombre = nombre;
        this.nombreCiudadOrigen = nombreCiudadOrigen;
        this.largoDeLaRutaDeEscape = largoDeLaRutaDeEscape;
    }

    public int largoDeLaRutaDeEscape() {
        return largoDeLaRutaDeEscape;
    }

    public boolean tieneOrigen(String nombreCiudad) {
        return this.nombreCiudadOrigen.equals(nombreCiudad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjetoRobado)) return false;
        ObjetoRobado that = (ObjetoRobado) o;
        return largoDeLaRutaDeEscape == that.largoDeLaRutaDeEscape && nombre.equals(that.nombre) && nombreCiudadOrigen.equals(that.nombreCiudadOrigen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, largoDeLaRutaDeEscape, nombreCiudadOrigen);
    }
}
