package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ContadorDeDificultadUnitTest {

    @Test
    public void test01AlRegistrarUnArrestoSeActualizaElRango() {

        Rango rangoMock = mock(Rango.class);
        when(rangoMock.actualizar(anyInt())).thenReturn(rangoMock);

        ContadorDeDificultad contador = new ContadorDeDificultad(rangoMock);

        contador.registrarArresto();

        verify(rangoMock, atLeastOnce()).actualizar(anyInt());
    }

    @Test
    public void test02AlRegistrarArrestos3VecesElContadorTiene3Arrestos() {

        Rango rangoMock = mock(Rango.class);
        when(rangoMock.actualizar(anyInt())).thenReturn(rangoMock);

        ContadorDeDificultad contador = new ContadorDeDificultad(rangoMock);

        for (int i = 0; i < 3; i++) {
            contador.registrarArresto();
        }

        assertEquals(3, contador.arrestos());
    }

}
