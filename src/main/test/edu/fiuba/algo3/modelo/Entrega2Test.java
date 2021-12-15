package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class Entrega2Test {

    /**
     * Caso de uso 1
     * - Detective sufre una herida de cuchillo.
     * - Detective duerme.
     */
    @Test
    public void test01DetectiveSufreHeridaDeCuchilloYDuerme() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));
        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        Cronometro cronometro = new Cronometro();

        EscenarioBuilder builder = new EscenarioBuilder().conCronometro(cronometro);
        builder.conCiudad("Mexico");

        algothief.generarEscenario(builder);

        algothief.recibirHeridaDeCuchillo();
        algothief.dormir();

        assertEquals(10, cronometro.tiempo());
    }

    /**
     * Caso de uso 2
     * - Detective con rango Investigador toma caso de un robo viaja de Montreal a México
     */
    @Test
    public void test02DetectiveInvestigadorTomaCasoYViajaDeMontrealAMexico() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));
        algothief.asignarDetective(new ContadorDeDificultad(new Investigador(), 10));

        Cronometro cronometro = new Cronometro();
        EscenarioBuilder builder = new EscenarioBuilder().conCronometro(cronometro);

        builder.conCiudad("Montreal");
        builder.conCiudad("Mexico");

        algothief.generarEscenario(builder);

        algothief.viajar("Mexico");

        int distanciaEntreCiudades = 3800; // km
        int tiempoEsperado = new Investigador().tiempoDeViaje(distanciaEntreCiudades) /*velocidad investigador*/;
        assertEquals(tiempoEsperado, cronometro.tiempo());
    }

    /**
     * Caso de uso 3
     * - Cargar en la computadora los datos recopilados y buscar sospechosos.
     */
    @Test
    public void test03DetectiveCargaDatosEnComputadoraYBuscaSospechoso() {

        // TODO: definir de dónde toma los datos el juego
        FuenteDeDatos fuente = mock(FuenteDeDatos.class);

        // ejemplo de mockeo (stubeo?) de FuenteDeDatos:
//        DescripcionSospechoso sospechoso1 = new DescripcionSospechoso().conNombre("Carmen SanDiego").conSexo("Femenino").conHobby("Tenis");
//        DescripcionSospechoso sospechoso2 = new DescripcionSospechoso().conNombre("Lucía").conSexo("Femenino").conHobby("Tenis");
//
//        when(fuente.descripciones()).thenReturn(List.of(sospechoso1, sospechoso2));

        Algothief algothief = new Algothief(fuente);
        algothief.asignarDetective(new ContadorDeDificultad(new Investigador(), 10));

        Cronometro cronometro = new Cronometro();
        EscenarioBuilder builder = new EscenarioBuilder().conCronometro(cronometro);
        builder.conCiudad("Montreal");

        algothief.generarEscenario(builder);

        // TODO: definir cómo manejamos las descripciones de los sospechosos
        DescripcionSospechoso descripcion = new DescripcionSospechoso().conSexo("Femenino").conHobby("Tenis");
        algothief.cargarDatosSospechoso(descripcion);

        assertEquals(List.of("Carmen SanDiego"), algothief.buscarSospechosos());
    }

    /**
     * Caso de uso 4
     * - Intentas atrapar al sospechoso sin la orden de arresto emitida.
     */
    @Test
    public void test04DetectiveIntentaAtraparAlSospechosoSinLaOrdenDeArrestoEmitida() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));
        algothief.asignarDetective(new ContadorDeDificultad(new Investigador(), 10));

        Cronometro cronometro = new Cronometro();
        EscenarioBuilder builder = new EscenarioBuilder().conCronometro(cronometro);
        builder.conCiudad("Montreal");

        algothief.generarEscenario(builder);

        algothief.atraparSospechoso();

        // TODO: definir cómo chequear esta prueba :(
        assertTrue(algothief.juegoAcabado());
        assertFalse(algothief.juegoGanado());
    }

    /**
     * Caso de uso 5
     * - Un detective hace 6 Arrestos.
     * - Toma un caso de un sospechoso que robó un Incan Gold Mask.
     * - Realiza la investigación.
     * - Emite la orden.
     * - Atrapa al sospechoso.
     */
    @Test
    public void test05DetectiveHace6ArrestosTomaCasoRealizaInvestigacionEmiteOrdenDeArrestoYAtrapaAlSospechoso() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilder builder = new EscenarioBuilder();

        builder.conCronometro(new Cronometro());

        builder.conObjetoRobado("Incan Gold Mask").conLadron("M");

        builder.conCiudad("Montreal").conEdificios("Banco Nacional", "Biblioteca de Montreal");
        builder.conCiudad("Mexico").conEdificios("Aeropuerto Nacional", "Puerto de Mexico");

        algothief.generarEscenario(builder);

        algothief.visitar("Banco Nacional");
        algothief.visitar("Banco Nacional");
        algothief.visitar("Biblioteca de Montreal");

        algothief.viajar("Mexico");
        algothief.visitar("Aeropuerto Nacional");

        DescripcionSospechoso descripcion = new DescripcionSospechoso().conSexo("Masculino").conHobby("Tenis");
        algothief.cargarDatosSospechoso(descripcion);
        algothief.buscarSospechosos();

        algothief.atraparSospechoso();

        assertTrue(algothief.juegoAcabado());
//        assertTrue(algothief.juegoGanado());
    }

}
