package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.rango.DetectiveRango;
import edu.fiuba.algo3.modelo.rango.Investigador;
import edu.fiuba.algo3.modelo.rango.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangoDetectiveUnitTest {

    @Test
    public void test01TiempoDeViajePara3800kmsEsCorrecto() {

        Rango rango = new DetectiveRango();

        int distancia = 3800; // km
        int velocidad = 1100; // km/h
        int tiempoEsperado = distancia / velocidad;

        assertEquals(tiempoEsperado, rango.tiempoDeViaje(3800));
    }

    @Test
    public void test02ActualizarCon10ArrestosActualizaAInvestigador() {

        Rango rango = new DetectiveRango();

        Rango rangoActualizado = rango.actualizar(10);

        assertEquals(Investigador.class, rangoActualizado.getClass());
    }

}
