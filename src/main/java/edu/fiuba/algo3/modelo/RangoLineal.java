package edu.fiuba.algo3.modelo;

public abstract class RangoLineal implements Rango {

    private final int arrestosParaActualizar;
    private final int velocidadDeViaje;
    private final String dificultad;

    protected RangoLineal(int arrestosParaActualizar, int velocidadDeViaje, String dificultad) {
        this.arrestosParaActualizar = arrestosParaActualizar;
        this.velocidadDeViaje = velocidadDeViaje;
        this.dificultad = dificultad;
    }

    @Override
    public Rango actualizar(int cantidadDeArrestos) {
        if (cantidadDeArrestos >= arrestosParaActualizar) {
            return this.siguiente();
        }
        return this;
    }

    public int tiempoDeViaje(int distanciaEnKms) {
        return distanciaEnKms / velocidadDeViaje;
    }

    abstract Rango siguiente();

    @Override
    public String dificultad() {
        return dificultad;
    }

}
