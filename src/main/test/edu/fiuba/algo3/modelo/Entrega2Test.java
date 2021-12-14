package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2Test {

    /**
     * Caso de uso 1
     * - Detective sufre una herida de cuchillo.
     * - Detective duerme.
     */
    @Test
    public void test01DetectiveSufreHeridaDeCuchilloYDuerme() {

        Algothief algothief = new Algothief();
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

        Algothief algothief = new Algothief();

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
        assertTrue(true);
    }

    /**
     * Caso de uso 4
     * - Intentas atrapar al sospechoso sin la orden de arresto emitida.
     */
    @Test
    public void test04DetectiveIntentaAtraparAlSospechosoSinLaOrdenDeArrestoEmitida() {
        assertTrue(true);
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
        assertTrue(true);
    }

}
