package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CiudadBuilderUnitTest {

    @Test
    public void test01CrearCiudadCon1EdificioCiudadCreadaTieneEseEdificio() {

        String nombreEdificio = "Banco Nacional";
        EdificioBuilder edificioBuilder = mock(EdificioBuilder.class);
        Edificio edificio = new Edificio(nombreEdificio, mock(Pista.class));
        when(edificioBuilder.construir()).thenReturn(edificio);

        CiudadBuilder builder = new CiudadBuilder("Montreal");
        builder.conEdificios(edificioBuilder);

        Ciudad ciudadCreada = builder.construir();

        assertDoesNotThrow(() -> ciudadCreada.obtenerEdificio(nombreEdificio));
    }

}
