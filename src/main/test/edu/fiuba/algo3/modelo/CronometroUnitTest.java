package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CronometroUnitTest {

    @Test
    public void test01CronometroEmpiezaEnLunesConHorasPasadasPorParametro() {

        Cronometro cronometro = new Cronometro(3);

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(3, cronometro.fechaActual().getHour());
    }

    @Test
    public void test02RegistrarVisitaEdificioConsume1Hora() {

        Cronometro cronometro = new Cronometro(0);
        Edificio edificio = mock(Edificio.class);

        cronometro.registrarVisita(edificio);

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(1, cronometro.fechaActual().getHour());
    }

    @Test
    public void test03RegistrarVisitaDeUnEdificioUnaVezYOtroEdificioDosVecesConsume4Horas() {

        Cronometro cronometro = new Cronometro(0);
        Edificio unEdificio = mock(Edificio.class);
        Edificio otroEdificio = mock(Edificio.class);

        cronometro.registrarVisita(unEdificio);

        cronometro.registrarVisita(otroEdificio);
        cronometro.registrarVisita(otroEdificio);

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(4, cronometro.fechaActual().getHour());
    }

    @Test
    public void test04RegistrarVisitaUnEdificioCuatroVecesConsume9Horas() {

        Cronometro cronometro = new Cronometro(0);
        Edificio unEdificio = mock(Edificio.class);

        for (int i = 0; i < 4; i++) {
            cronometro.registrarVisita(unEdificio);
        }

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(9, cronometro.fechaActual().getHour());
    }

    @Test
    public void test05RegistrarDormirConsume8Horas() {

        Cronometro cronometro = new Cronometro(0);

        cronometro.registrarDormir();

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(8, cronometro.fechaActual().getHour());
    }

    @Test
    public void test06RegistrarDormir3VecesConsume24Horas() {

        Cronometro cronometro = new Cronometro(0);

        for (int i = 0; i < 3; i++) {
            cronometro.registrarDormir();
        }

        assertEquals(DayOfWeek.TUESDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(0, cronometro.fechaActual().getHour());
    }

    @Test
    public void test07RegistrarBalazo1VezConsume4Horas() {

        Cronometro cronometro = new Cronometro(0);
        Ciudad ciudad = mock(Ciudad.class);
        ContadorDeDificultad contador = mock(ContadorDeDificultad.class);

        Policia detective = new Policia(cronometro, ciudad, contador);

        detective.recibirHeridaPorArmaDeFuego();

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(4, cronometro.fechaActual().getHour());
    }

    @Test
    public void test08RegistrarBalazo5VecesConsume20Horas() {

        Cronometro cronometro = new Cronometro(0);

        for (int i = 0; i < 5; i++) {
            cronometro.registrarHeridaPorArmaDeFuego();
        }

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(20, cronometro.fechaActual().getHour());
    }

}
