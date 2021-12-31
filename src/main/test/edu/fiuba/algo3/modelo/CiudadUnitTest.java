package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadUnitTest {

    @Test
    public void test01CiudadCreadaConUnEdificioDevuelveEseEdificio() {

        String nombreEdificio = "nombre del edificio";
        String nombreCiudad = "Ciudad de prueba";

        /* habría que usar un stub acá?
        Edificio edificioStub = mock(Edificio.class);
        when(edificioStub.es(nombreEdificio)).thenReturn(true);
         */

        Edificio edificio = new Edificio(nombreEdificio, new Pista("desc"));

        Ciudad ciudad = new Ciudad(nombreCiudad, List.of(edificio), List.of(),
                new Coordenadas(0.0, 0.0), new Ladron("", new DescripcionSospechoso()));

        assertEquals(edificio, ciudad.obtenerEdificio(nombreEdificio));
    }

    @Test
    public void test02CiudadCreadaConVariosEdificiosDevuelveEdificioCorrecto() {

        String nombreEsperado = "Edificio esperado";
        String nombreCiudad = "Ciudad de prueba";

        Edificio edificio1 = new Edificio("Edificio 1", new Pista("desc"));
        Edificio edificioEsperado = new Edificio(nombreEsperado, new Pista("desc"));
        Edificio edificio2 = new Edificio("Edificio 2", new Pista("desc"));

        Ciudad ciudad = new Ciudad(nombreCiudad, List.of(edificio1, edificioEsperado, edificio2), List.of(),
                new Coordenadas(0.0, 0.0), new Ladron("", new DescripcionSospechoso()));

        assertEquals(edificioEsperado, ciudad.obtenerEdificio(nombreEsperado));
    }

}
