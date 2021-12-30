package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PoliciaUnitTest {

    @Test
    public void test01DetectiveVisitaEdificioDevuelvePistaCorrecta() {

        Cronometro cronometro = mock(Cronometro.class);
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);
        Edificio edificio = mock(Edificio.class);
        Pista pista = mock(Pista.class);

        when(ciudad.obtenerEdificio("nombreEdificio")).thenReturn(edificio);
        when(edificio.obtenerPista()).thenReturn(pista);

        Policia detective = new Policia(cronometro, ciudad, contador);

        Pista pistaDevuelta = detective.visitar("nombreEdificio");

        assertEquals(pista, pistaDevuelta);
    }

    @Test
    public void test02RegistrarHeridaDeCuchilloConsume2Horas() {

        Cronometro cronometro = new Cronometro(0);
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);

        Policia detective = new Policia(cronometro, ciudad, contador);

        detective.recibirHeridaDeCuchillo();

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(2, cronometro.fechaActual().getHour());
    }

    @Test
    public void test03RegistrarHeridaDeCuchillo4VecesConsume5Horas() {

        Cronometro cronometro = new Cronometro(0);
        Salud salud = mock(Salud.class);

        when(salud.tiempoDeRecuperacion()).thenReturn(2);

        cronometro.registrarHeridaDeCuchillo(salud);

        when(salud.tiempoDeRecuperacion()).thenReturn(1);

        for (int i = 0; i < 3; i++) {
            cronometro.registrarHeridaDeCuchillo(salud);
        }

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(5, cronometro.fechaActual().getHour());
    }

    @Test
    public void test04RegistrarViajeCambiaEdificiosVisitablesPorLosDeLaNuevaCiudad() {

        Cronometro cronometro = mock(Cronometro.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);

        List<String> edificiosCiudadOrigen = List.of("Edificio 1", "Edificio 2");
        List<String> edificiosCiudadDestino = List.of("Edificio 3", "Edificio 4");

        Ciudad ciudadOrigen = mock(Ciudad.class);
        Ciudad ciudadDestino = mock(Ciudad.class);
        when(ciudadOrigen.edificiosVisitables()).thenReturn(edificiosCiudadOrigen);
        when(ciudadDestino.edificiosVisitables()).thenReturn(edificiosCiudadDestino);

        Policia detective = new Policia(cronometro, ciudadOrigen, contador);

        detective.viajar(ciudadDestino);

        assertEquals(edificiosCiudadDestino, detective.edificiosVisitables());
    }

}
