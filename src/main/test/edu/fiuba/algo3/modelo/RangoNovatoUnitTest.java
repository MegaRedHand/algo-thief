package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.DetectiveRango;
import edu.fiuba.algo3.modelo.Novato;
import edu.fiuba.algo3.modelo.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(DetectiveRango.class, rangoActualizado.getClass());
    }

}
