package edu.fiuba.algo3.modelo;

public interface EscenarioBuilder {
    Escenario construirCon(ContadorDeDificultad contador, FuenteDeDatos fuente);
    Cronometro obtenerCronometro();
}
