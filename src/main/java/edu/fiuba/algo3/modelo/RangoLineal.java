package edu.fiuba.algo3.modelo;

public abstract class RangoLineal implements Rango {

    private final int arrestosParaActualizar;
    private final int velocidadDeViaje;

    protected RangoLineal(int arrestosParaActualizar, int velocidadDeViaje) {
        this.arrestosParaActualizar = arrestosParaActualizar;
        this.velocidadDeViaje = velocidadDeViaje;
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

}
