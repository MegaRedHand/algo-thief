package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        Algothief algothief = new Algothief();

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilder builder = new EscenarioBuilder();

        builder.conCronometro(new Cronometro());

        builder.conObjetoRobado("Tesoro Nacional de Montreal").conLadron("F");
        builder.conCiudad("Montreal").yEdificios("Banco Nacional");

        algothief.generarEscenario(builder);

        algothief.visitarEdificio("Banco Nacional");
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

        Algothief algothief = new Algothief();

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilder builder = new EscenarioBuilder();

        Cronometro cronometro = new Cronometro();
        builder.conCronometro(cronometro);

        builder.conObjetoRobado("Tesoro Nacional de Montreal").conLadron("F");
        builder.conCiudad("Montreal").yEdificios("Banco Nacional", "Biblioteca de Montreal");

        algothief.generarEscenario(builder);

        algothief.visitarEdificio("Banco Nacional");
        String pistaBanco = algothief.pistaMasReciente();

        algothief.visitarEdificio("Biblioteca de Montreal");
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

        Cronometro cronometro = new Cronometro();

        Rango rango = new Novato();

        Ciudad montreal = new Ciudad("Montreal");
        Ciudad mexico = new Ciudad("México");

        Detective detective = new Detective(cronometro, montreal, new ContadorDeDificultad(rango, 0));

        detective.viajar(montreal);

        int distanciaEntreCiudades = 3800; // km
        int tiempoEsperado = rango.tiempoDeViaje(distanciaEntreCiudades) /*velocidad novato*/;
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

        Cronometro cronometro = new Cronometro();

        Rango rango = new Novato();

        Facil pistaAeropuerto = new Facil("esta es la pista del aeropuerto");
        Facil pistaPuerto = new Facil("esta es la pista del puerto");

        Edificio aeropuerto = new Edificio("Banco Nacional", pistaAeropuerto);
        Edificio puerto = new Edificio("Biblioteca de Montreal", pistaPuerto);

        Ciudad montreal = new Ciudad("Montreal", aeropuerto, puerto);

        Detective detective = new Detective(cronometro, montreal, new ContadorDeDificultad(rango, 0));

        for (int i = 0; i < 2; i++) {
            detective.visitar(aeropuerto);
        }

        for (int i = 0; i < 54; i++) {
            detective.visitar(puerto);
        }

        assertEquals(pistaAeropuerto, detective.visitar(aeropuerto));
        assertEquals(pistaPuerto, detective.visitar(puerto));

        assertEquals(168, cronometro.tiempo());
    }

    /**Caso de uso 5
     * - Detective sufre una herida de cuchillo.
     * - Detective duerme.
     */
    @Test
    public void test05DetectiveSufreHeridaDeCuchilloYDuerme() {
        Cronometro cronometro = new Cronometro();

        Rango rango = new Novato();

        Ciudad montreal = new Ciudad("Montreal");

        Detective detective = new Detective(cronometro, montreal, new ContadorDeDificultad(rango, 0));

        detective.recibirHeridaDeCuchillo();
        detective.dormir();

        assertEquals(10, cronometro.tiempo());
    }

}
