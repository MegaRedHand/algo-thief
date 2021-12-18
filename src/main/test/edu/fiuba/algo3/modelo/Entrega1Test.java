package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.rango.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

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

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilder builder = new EscenarioBuilder();

        builder.conCronometro(new Cronometro());

        builder.conObjetoRobado(new Comun("Tesoro Nacional de Montreal"));
        builder.conLadron("Sospechoso", new DescripcionSospechoso(new Rasgo("Sexo", "Femenino")));
        builder.conCiudad("Montreal").conEdificios("Banco Nacional");

        algothief.generarEscenario(builder);

        algothief.visitar("Banco Nacional");
        assertEquals("Descripción de la pista", algothief.pistaMasReciente());
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

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilder builder = new EscenarioBuilder();

        Cronometro cronometro = new Cronometro();
        builder.conCronometro(cronometro);

        builder.conCiudad("Montreal").conEdificios("Banco Nacional", "Biblioteca de Montreal");

        algothief.generarEscenario(builder);

        algothief.visitar("Banco Nacional"); // TODO: visitarEdificio o detectivaVisitaEdificio?
        String pistaBanco = algothief.pistaMasReciente();

        algothief.visitar("Biblioteca de Montreal");
        String pistaBiblioteca = algothief.pistaMasReciente();

        assertEquals("Descripción de la pista", pistaBanco);
        assertEquals("Descripción de la pista", pistaBiblioteca);

        assertEquals(2, cronometro.tiempo());
    }


    /**
     *Caso de uso 3
     * - Detective viaja de Montreal a México
     */
    @Test
    public void test03DetectiveViajaDeMontrealAMexico() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilder builder = new EscenarioBuilder();

        Cronometro cronometro = new Cronometro();
        builder.conCronometro(cronometro);

        builder.conCiudad("Montreal");
        builder.conCiudad("Mexico");

        algothief.generarEscenario(builder);

        algothief.viajar("Mexico");

        int distanciaEntreCiudades = 3800; // km
        int tiempoEsperado = new Novato().tiempoDeViaje(distanciaEntreCiudades) /*velocidad novato*/;
        assertEquals(tiempoEsperado, cronometro.tiempo());
    }


    /**Caso de uso 4
     * - Visita un Aeropuerto (3 veces):
     *   - Se despliega una pista.
     * - Visita un Puerto (55 veces):
     *   - Se despliega una pista.
     */
    @Test
    public void test04DetectiveAlVisitaAeropuertoSeDespliegaPistaYAlVisitarPuertoSeDespliegaPista() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilder builder = new EscenarioBuilder();

        Cronometro cronometro = new Cronometro();
        builder.conCronometro(cronometro);

        String nombreAeropuerto = "Aeropuerto Nacional";
        String nombrePuerto = "Puerto de Mexico";

        builder.conCiudad("Mexico").conEdificios(nombreAeropuerto, nombrePuerto);

        algothief.generarEscenario(builder);


        for (int i = 0; i < 3; i++) {
            algothief.visitar(nombreAeropuerto);
        }

        String pistaDevueltaAeropuerto = algothief.pistaMasReciente();

        for (int i = 0; i < 55; i++) {
            algothief.visitar(nombrePuerto);
        }

        assertEquals("Descripción de la pista", pistaDevueltaAeropuerto);
        assertEquals("Descripción de la pista", algothief.pistaMasReciente());

        assertEquals(168, cronometro.tiempo());
    }

    /**Caso de uso 5
     * - Detective sufre una herida de cuchillo.
     * - Detective duerme.
     */
    @Test
    public void test05DetectiveSufreHeridaDeCuchilloYDuerme() {

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

}
