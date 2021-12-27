package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega1Test {

    /**Caso de uso 1
     * - Robaron el tesoro Nacional de Montreal.
     * - Sospechoso femenino.
     * - Detective novato comienza en Montreal.
     * - Visita un Banco:
     *   - Se despliega una pista.
     */
    @Test
    public void test01DetectiveNovatoEmpiezaEnMontrealYAlVisitarBancoDespliegaUnaPista() {

        FuenteDeDatos fuente = mock(FuenteDeDatos.class);
        Pista pista = new Pista("Descripcion de la pista del banco");
        when(fuente.obtenerPista(anyString(), anyString())).thenReturn(pista);
        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        builder.conCronometro(new Cronometro(0));

        builder.conObjetoRobado(new Comun("Tesoro Nacional de Montreal"));
        builder.conLadron("Sospechoso", new DescripcionSospechoso(new Rasgo("Sexo", "Femenino")));
        builder.conCiudades(
                new CiudadBuilder("Montreal").conEdificios(
                        new EdificioBuilder("Banco Nacional", "banco")
                )
        );

        algothief.generarEscenario(builder);

        algothief.visitar("Banco Nacional");
        assertEquals(pista.descripcion(), algothief.pistaMasReciente());
    }


    /**Caso de uso 2
     * - Detective novato comienza en Montreal.
     * - Visita un Banco (nuevamente):
     *   - Se despliega una pista
     * - Visita una Biblioteca:
     *   -Se despliega una pista.
     */
    @Test
    public void test02DetectiveNovatoEmpiezaEnMontrealYAlVisitarVariosEdificiosDespliegaVariasPistas() {

        FuenteDeDatos fuente = mock(FuenteDeDatos.class);

        Pista pistaBanco = new Pista("Descripcion de la pista del banco");
        when(fuente.obtenerPista(anyString(), eq("banco"))).thenReturn(pistaBanco);

        Pista pistaBiblioteca = new Pista("Descripcion de la pista de la biblioteca");
        when(fuente.obtenerPista(anyString(), eq("biblioteca"))).thenReturn(pistaBiblioteca);

        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        Cronometro cronometro = new Cronometro(7);
        builder.conCronometro(cronometro);

        builder.conCiudades(
                new CiudadBuilder("Montreal").conEdificios(
                        new EdificioBuilder("Banco Nacional", "banco"),
                        new EdificioBuilder("Biblioteca de Montreal", "biblioteca")
                )
        );

        algothief.generarEscenario(builder);

        algothief.visitar("Banco Nacional");
        String pistaDevueltaBanco = algothief.pistaMasReciente();

        algothief.visitar("Biblioteca de Montreal");
        String pistaDevueltaBiblioteca = algothief.pistaMasReciente();

        assertEquals(pistaBanco.descripcion(), pistaDevueltaBanco);
        assertEquals(pistaBiblioteca.descripcion(), pistaDevueltaBiblioteca);

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(9, cronometro.fechaActual().getHour());
    }


    /**
     *Caso de uso 3
     * - Detective viaja de Montreal a México
     */
    @Test
    public void test03DetectiveViajaDeMontrealAMexico() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        Cronometro cronometro = new Cronometro(7);
        builder.conCronometro(cronometro);

        builder.conCiudades(
                new CiudadBuilder("Montreal"),
                new CiudadBuilder("Mexico")
        );

        algothief.generarEscenario(builder);

        algothief.viajar("Mexico");

        int distanciaEntreCiudades = 3800; // km
        int tiempoEsperado = new Novato().tiempoDeViaje(distanciaEntreCiudades) /*velocidad novato*/;

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(7 + tiempoEsperado, cronometro.fechaActual().getHour());
    }


    /**Caso de uso 4
     * - Visita un Aeropuerto (3 veces):
     *   - Se despliega una pista.
     * - Visita un Puerto (55 veces):
     *   - Se despliega una pista.
     */
    @Test
    public void test04DetectiveAlVisitarAeropuertoSeDespliegaPistaYAlVisitarPuertoSeDespliegaPista() {

        FuenteDeDatos fuente = mock(FuenteDeDatos.class);

        Pista pistaAeropuerto = new Pista("Descripción del aeropuerto");
        when(fuente.obtenerPista(anyString(), eq("aeropuerto"))).thenReturn(pistaAeropuerto);

        Pista pistaPuerto = new Pista("Descripción del puerto");
        when(fuente.obtenerPista(anyString(), eq("puerto"))).thenReturn(pistaPuerto);

        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        Cronometro cronometro = new Cronometro(7);
        EscenarioBuilderManual builder = new EscenarioBuilderManual().conCronometro(cronometro);


        String nombreAeropuerto = "Aeropuerto Nacional";
        String nombrePuerto = "Puerto de Mexico";

        builder.conCiudades(
                new CiudadBuilder("Mexico").conEdificios(
                        new EdificioBuilder(nombreAeropuerto, "aeropuerto"),
                        new EdificioBuilder(nombrePuerto, "puerto")
                )
        );

        algothief.generarEscenario(builder);


        for (int i = 0; i < 3; i++) {
            algothief.visitar(nombreAeropuerto);
        }

        String pistaDevueltaAeropuerto = algothief.pistaMasReciente();

        for (int i = 0; i < 55; i++) {
            algothief.visitar(nombrePuerto);
        }

        assertEquals(pistaAeropuerto.descripcion(), pistaDevueltaAeropuerto);
        assertEquals(pistaPuerto.descripcion(), algothief.pistaMasReciente());

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(7, cronometro.fechaActual().getHour());
        assertTrue(cronometro.seAcaboElTiempo());
    }

    /**Caso de uso 5
     * - Detective sufre una herida de cuchillo.
     * - Detective duerme.
     */
    @Test
    public void test05DetectiveSufreHeridaDeCuchilloYDuerme() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));
        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        Cronometro cronometro = new Cronometro(7);

        EscenarioBuilderManual builder = new EscenarioBuilderManual().conCronometro(cronometro);
        builder.conCiudades(new CiudadBuilder("Mexico"));

        algothief.generarEscenario(builder);

        algothief.recibirHeridaDeCuchillo();
        algothief.dormir();

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(17, cronometro.fechaActual().getHour());
    }

}
