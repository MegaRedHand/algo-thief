package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RangoNovatoUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecto() {

        Rango rango = new Novato();

        int distancia = 3800; // km
        int velocidad = 900; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }

    @Test
    public void test02ActualizarCon5ArrestosActualizaARangoDetective() {

        Rango rango = new Novato();

        Rango rangoActualizado = rango.actualizar(5);

        assertEquals(Detective.class, rangoActualizado.getClass());
    }

    @Test
    public void test03RangoNovatoGeneraPistasFaciles() {

        Rango rango = new Novato();
        GeneradorDePistas generadorDePistas = mock(GeneradorDePistas.class);

        rango.generarPistaCon(generadorDePistas, Map.of(), new DescripcionSospechoso());

        verify(generadorDePistas, atLeastOnce()).generarPistaFacil(any(), any());
    }

}
