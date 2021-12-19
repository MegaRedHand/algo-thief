package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Novato;
import edu.fiuba.algo3.modelo.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CiudadBuilderUnitTest {

    @Test
    public void test01CrearCiudadCon1EdificioCiudadCreadaTieneEseEdificio() {

        String nombreEdificio = "Banco Nacional";
        FuenteDeDatos fuente = mock(FuenteDeDatos.class);
        EdificioBuilder edificioBuilder = mock(EdificioBuilder.class);
        Edificio edificio = new Edificio(nombreEdificio, mock(Pista.class));
        Rango rango = new Novato();
        when(edificioBuilder.construirCon(rango, fuente)).thenReturn(edificio);

        CiudadBuilder builder = new CiudadBuilder("Montreal");
        builder.conEdificios(edificioBuilder);

        Ciudad ciudadCreada = builder.construirCon(rango, fuente);

        assertDoesNotThrow(() -> ciudadCreada.obtenerEdificio(nombreEdificio));
    }

}
