package edu.fiuba.algo3.modelo;

public abstract class ObjetoRobado {

    protected final String nombre;
    private final int largoDeLaRutaDeEscape;

    public ObjetoRobado(String nombre, int largoDeLaRutaDeEscape) {
        this.nombre = nombre;
        this.largoDeLaRutaDeEscape = largoDeLaRutaDeEscape;
    }

    public int largoDeLaRutaDeEscape() {
        return largoDeLaRutaDeEscape;
    }

}
