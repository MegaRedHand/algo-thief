package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NovatoUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecta() {

        Rango rango = new Novato();

        int distancia = 3800; // km
        int velocidad = 900; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }

}
