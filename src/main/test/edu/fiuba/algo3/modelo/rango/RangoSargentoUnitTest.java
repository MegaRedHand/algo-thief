package edu.fiuba.algo3.modelo.rango;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangoSargentoUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecto() {

        Rango rango = new Sargento();

        int distancia = 3800; // km
        int velocidad = 1500; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }

    @Test
    public void test02ActualizarCon60ArrestosSigueSiendoSargento() {

        Rango rango = new Sargento();

        Rango rangoActualizado = rango.actualizar(60);

        assertEquals(Sargento.class, rangoActualizado.getClass());
    }

}
