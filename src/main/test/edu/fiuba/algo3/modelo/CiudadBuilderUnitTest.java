package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CiudadBuilderUnitTest {

    @Test
    public void test01CrearCiudadCon1EdificioCiudadCreadaTieneEseEdificio() {

        String nombreEdificio = "Banco Nacional";
        CiudadBuilder builder = new CiudadBuilder("Montreal");
        builder.conEdificios(nombreEdificio);

        Ciudad ciudadCreada = builder.construir();

        assertDoesNotThrow(() -> ciudadCreada.obtenerEdificio(nombreEdificio));
    }

}
