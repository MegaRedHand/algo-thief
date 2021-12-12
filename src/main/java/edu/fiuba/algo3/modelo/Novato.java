package edu.fiuba.algo3.modelo;

public class Novato implements Rango {

    @Override
    public Rango actualizar(int cantidadDeArrestos) {
        if (cantidadDeArrestos >= 10) {
            return this.siguiente();
        }
        return this;
    }

    public int tiempoDeViaje(int distanciaEnKms) {
        return distanciaEnKms / 900;
    }

    private Rango siguiente() {
        return this; // TODO: debería devolver el siguiente rango
    }

}
