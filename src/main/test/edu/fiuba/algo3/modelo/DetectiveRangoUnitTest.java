package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectiveRangoUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecto() {

        Rango rango = new DetectiveRango();

        int distancia = 3800; // km
        int velocidad = 1100; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }

}
