package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CiudadUnitTest {

    @Test
    public void test01CiudadCreadaConUnEdificioDevuelveEseEdificio() {

        String nombreEdificio = "nombre del edificio";
        String nombreCiudad = "Ciudad de prueba";

        /* habría que usar un mock acá?
        Edificio edificioStub = mock(Edificio.class);
        when(edificioStub.es(nombreEdificio)).thenReturn(true);
         */

        Edificio edificio = new Edificio(nombreEdificio, new Pista("desc"));

        Ciudad ciudad = new Ciudad(nombreCiudad, edificio);

        assertEquals(edificio, ciudad.obtenerEdificio(nombreEdificio));
    }

    @Test
    public void test02CiudadCreadaConVariosEdificiosDevuelveEdificioCorrecto() {

        String nombreEsperado = "Edificio esperado";
        String nombreCiudad = "Ciudad de prueba";

        Edificio edificio1 = new Edificio("Edificio 1", new Pista("desc"));
        Edificio edificioEsperado = new Edificio(nombreEsperado, new Pista("desc"));
        Edificio edificio2 = new Edificio("Edificio 2", new Pista("desc"));

        Ciudad ciudad = new Ciudad(nombreCiudad, edificio1, edificioEsperado, edificio2);

        assertEquals(edificioEsperado, ciudad.obtenerEdificio(nombreEsperado));
    }

}
