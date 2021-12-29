package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Investigador;
import edu.fiuba.algo3.modelo.Rango;
import edu.fiuba.algo3.modelo.Sargento;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RangoInvestigadorUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecto() {

        Rango rango = new Investigador();

        int distancia = 3800; // km
        int velocidad = 1300; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }

    @Test
    public void test02ActualizarCon20ArrestosActualizaASargento() {

        Rango rango = new Investigador();

        Rango rangoActualizado = rango.actualizar(20);

        assertEquals(Sargento.class, rangoActualizado.getClass());
    }

    @Test
    public void test03RangoInvestigadorGeneraPistasMedias() {

        Rango rango = new Investigador();
        GeneradorDePistas generadorDePistas = mock(GeneradorDePistas.class);

        rango.generarPistaCon(generadorDePistas, Map.of(), new DescripcionSospechoso());

        verify(generadorDePistas, atLeastOnce()).generarPistaMedia(any(), any());
    }
    
}
