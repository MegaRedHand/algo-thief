package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.EdificioBuilder;
import edu.fiuba.algo3.modelo.FuenteDeDatos;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EdificioBuilderUnitTest {

    @Test
    public void test01ConstruirEdificioDevuelveEdificioConNombreCorrecto() {

        String nombreEdificio = "Banco Nacional";
        Pista pista = new Pista("Descripción");
        EdificioBuilder builder = new EdificioBuilder(nombreEdificio, "banco");
        builder.conPista(pista);

        Edificio edificioCreado = builder.construir();

        assertTrue(edificioCreado.es(nombreEdificio));
    }

    @Test
    public void test02ConstruirEdificioLeAgregaPistaConLaDescripcionCorrecta() {

        Pista pista = new Pista("Descripción");
        EdificioBuilder builder = new EdificioBuilder("Banco Nacional");
        builder.conPista(pista);

        Edificio edificioCreado = builder.construir();

        assertEquals(pista.descripcion(), edificioCreado.obtenerPista().descripcion());
    }

}
