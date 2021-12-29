package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Rango;
import edu.fiuba.algo3.modelo.Sargento;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

    @Test
    public void test03RangoSargentoGeneraPistasDificiles() {

        Rango rango = new Sargento();
        GeneradorDePistas generadorDePistas = mock(GeneradorDePistas.class);

        rango.generarPistaCon(generadorDePistas, Map.of(), new DescripcionSospechoso());

        verify(generadorDePistas, atLeastOnce()).generarPistaDificil(any(), any());
    }

}
