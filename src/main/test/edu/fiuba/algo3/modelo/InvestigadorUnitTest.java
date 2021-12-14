package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvestigadorUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecto() {

        Rango rango = new Investigador();

        int distancia = 3800; // km
        int velocidad = 1300; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }
    
}
