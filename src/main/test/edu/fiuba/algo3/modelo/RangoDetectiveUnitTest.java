package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RangoDetectiveUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecto() {

        Rango rango = new Detective();

        int distancia = 3800; // km
        int velocidad = 1100; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }

    @Test
    public void test02ActualizarCon10ArrestosActualizaAInvestigador() {

        Rango rango = new Detective();

        Rango rangoActualizado = rango.actualizar(10);

        assertEquals(Investigador.class, rangoActualizado.getClass());
    }

    @Test
    public void test03RangoDetectiveGeneraPistasFaciles() {

        Rango rango = new Detective();
        GeneradorDePistas generadorDePistas = mock(GeneradorDePistas.class);

        rango.generarPistaCon(generadorDePistas, Map.of(), new DescripcionSospechoso());

        verify(generadorDePistas, atLeastOnce()).generarPistaFacil(any(), any());
    }

}
