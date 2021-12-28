package edu.fiuba.algo3.modelo;

public abstract class ObjetoRobado {

    protected final String nombre;
    private final int largoDeLaRutaDeEscape;
    private final String nombreCiudadOrigen;

    public ObjetoRobado(String nombre, String nombreCiudadOrigen, int largoDeLaRutaDeEscape) {
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
}
