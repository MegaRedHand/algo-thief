package edu.fiuba.algo3.modelo;

public interface Rango {
    Rango actualizar(int cantidadDeArrestos);
    int tiempoDeViaje(int distanciaEnKms);
    String dificultad();
}
