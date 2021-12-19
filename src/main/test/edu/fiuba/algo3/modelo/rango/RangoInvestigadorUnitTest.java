package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.rango.Investigador;
import edu.fiuba.algo3.modelo.rango.Rango;
import edu.fiuba.algo3.modelo.rango.Sargento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    
}
