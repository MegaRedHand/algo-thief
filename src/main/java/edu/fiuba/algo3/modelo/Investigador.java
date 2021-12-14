package edu.fiuba.algo3.modelo;

public class Investigador implements Rango {

    @Override
    public Rango actualizar(int cantidadDeArrestos) {
        return this;
    }

    @Override
    public int tiempoDeViaje(int distanciaEnKms) {
        return distanciaEnKms / 1300;
    }

}
