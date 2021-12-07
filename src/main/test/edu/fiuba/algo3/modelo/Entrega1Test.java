package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class Entrega1Test {
    Cronometro cronometro;
    Rango rango;
    Comun objeto;
    Ladron ladron;

    Facil pistaBanco;
    Facil pistaBiblioteca;
    Facil pistaAeropuerto;
    Facil pistaPuerto;

    Edificio banco;
    Edificio biblioteca;
    Edificio aeropuerto;
    Edificio puerto;

    Ciudad montreal;
    Ciudad mexico;


    @BeforeEach
    void setUp() {
        cronometro = new Cronometro();
        rango = new Novato();
        objeto = new Comun("Tesoro Nacional de Montreal");
        ladron = new Ladron(objeto,"F");

        pistaBanco = new Facil("esta es la pista del banco");
        pistaBiblioteca = new Facil("esta es la pista del biblioteca");
        pistaAeropuerto = new Facil("pista del aeropuerto");
        pistaPuerto = new Facil("pista del puerto");

        banco = new Edificio("Banco Nacional", pistaBanco);
        biblioteca = new Edificio("Biblioteca de Montreal", pistaBiblioteca);
        aeropuerto = new Edificio("Banco Nacional", pistaAeropuerto);
        puerto = new Edificio("Biblioteca de Montreal", pistaPuerto);

        montreal = new Ciudad("Montreal", banco, biblioteca);
        mexico = new Ciudad("México", aeropuerto, puerto);
    }
    /**Caso de uso 1
     * - Robaron el tesoro Nacional de Montreal.
     * - Sospechoso femenino.
     * - Detective novato comienza en Montreal.
     * - Visita un Banco:
     *   - Se despliega una pista.
     */
    @Test
    public void test01DetectiveNovatoEmpiezaEnMontrealYAlVisitarBancoDespliegaUnaPista() {

        Detective detective = new Detective(cronometro, montreal, rango);

        assertEquals(pistaBanco, detective.visitar(banco));
        assertEquals(1, cronometro.tiempo());
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

        Detective detective = new Detective(cronometro, montreal, rango);

        assertEquals(pistaBanco, detective.visitar(banco));
        assertEquals(pistaBiblioteca, detective.visitar(biblioteca));

        assertEquals(2, cronometro.tiempo());
    }


    /**
     *Caso de uso 3
     * - Detective viaja de Montreal a México
     */
    @Test
    public void test03DetectiveViajaDeMontrealAMexico() {

        Detective detective = new Detective(cronometro, montreal, rango);

        detective.viajar(mexico);

        int distanciaEntreCiudades = 3800; // km
        int tiempoEsperado = distanciaEntreCiudades / 900 /*velocidad novato*/;
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

        Detective detective = new Detective(cronometro, mexico, rango);

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
    public void detectiveSufreHeridaDeCuchilloYDuerme() {

        Detective detective = new Detective(cronometro, mexico, rango);

        detective.recibirHeridaDeCuchillo();
        detective.dormir();

        assertEquals(10, cronometro.tiempo());
    }
}
