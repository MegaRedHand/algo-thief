package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.EdificioBuilder;
import edu.fiuba.algo3.modelo.FuenteDeDatos;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EdificioBuilderUnitTest {

    @Test
    public void test01ConstruirEdificioLeAgregaPistaConLaDescripcionCorrecta() {

        FuenteDeDatos fuente = mock(FuenteDeDatos.class);
        Pista pista = new Pista("Descripción");
        when(fuente.obtenerPista("facil", "banco")).thenReturn(pista);
        EdificioBuilder builder = new EdificioBuilder("Banco Nacional", "banco");

        Edificio edificioCreado = builder.construirCon(new Novato(), fuente);

        assertEquals(pista.descripcion(), edificioCreado.obtenerPista().descripcion());
    }

}
