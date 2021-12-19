package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DetectiveUnitTest {

    @Test
    public void test01DetectiveVisitaEdificioDevuelvePistaCorrecta() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);
        Edificio edificio = mock(Edificio.class);
        Pista pista = mock(Pista.class);

        when(ciudad.obtenerEdificio("nombreEdificio")).thenReturn(edificio);
        when(edificio.obtenerPista()).thenReturn(pista);

        Detective detective = new Detective(cronometro, ciudad, contador);

        Pista pistaDevuelta = detective.visitar("nombreEdificio");

        assertEquals(pista, pistaDevuelta);
    }

    @Test
    public void test02DetectiveVisitaEdificioYConsume1Hora() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);
        Edificio edificio = mock(Edificio.class);

        when(ciudad.obtenerEdificio("nombreEdificio")).thenReturn(edificio);

        Detective detective = new Detective(cronometro, ciudad, contador);

        detective.visitar("nombreEdificio");

        assertEquals(1, cronometro.tiempo());
    }

    @Test
    public void test03DetectiveVisitaUnEdificioUnaVezYOtroEdificioDosVecesYConsume4Horas() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);
        Edificio unEdificio = mock(Edificio.class);
        Edificio otroEdificio = mock(Edificio.class);

        when(ciudad.obtenerEdificio("unEdificio")).thenReturn(unEdificio);
        when(ciudad.obtenerEdificio("otroEdificio")).thenReturn(otroEdificio);

        Detective detective = new Detective(cronometro, ciudad, contador);

        detective.visitar("unEdificio");

        detective.visitar("otroEdificio");
        detective.visitar("otroEdificio");

        assertEquals(4, cronometro.tiempo());
    }

    @Test
    public void test04DetectiveVisitaUnEdificioCuatroVecesYConsume9Horas() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);
        Edificio edificio = mock(Edificio.class);
        when(ciudad.obtenerEdificio("nombreEdificio")).thenReturn(edificio);

        Detective detective = new Detective(cronometro, ciudad, contador);

        for (int i = 0; i < 4; i++) {
            detective.visitar("nombreEdificio");
        }

        assertEquals(9, cronometro.tiempo());
    }

    @Test
    public void test05DetectiveRecibeUnaHeridaDeCuchilloYConsume2Horas() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);

        Detective detective = new Detective(cronometro, ciudad, contador);

        detective.recibirHeridaDeCuchillo();

        assertEquals(2, cronometro.tiempo());
    }

    @Test
    public void test06DetectiveRecibe4HeridasDeCuchilloYConsume5Horas() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);

        Detective detective = new Detective(cronometro, ciudad, contador);

        for (int i = 0; i < 4; i++) {
            detective.recibirHeridaDeCuchillo();
        }

        assertEquals(5, cronometro.tiempo());
    }

    @Test
    public void test07DetectiveDuermeUnaVezYConsume8Horas() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);

        Detective detective = new Detective(cronometro, ciudad, contador);

        detective.dormir();

        assertEquals(8, cronometro.tiempo());
    }

    @Test
    public void test08DetectiveDuermeTresVecesYConsume24Horas() {

        Cronometro cronometro = new Cronometro();
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);

        Detective detective = new Detective(cronometro, ciudad, contador);

        for (int i = 0; i < 3; i++) {
            detective.dormir();
        }

        assertEquals(24, cronometro.tiempo());
    }

}
