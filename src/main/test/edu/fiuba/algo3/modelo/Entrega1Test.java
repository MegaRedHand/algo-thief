package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

        Cronometro cronometro = mock(Cronometro.class);
        Rango rango = new Novato();
        Comun objeto = new Comun("Tesoro Nacional de Montreal");
        Ladron ladron = new Ladron(objeto,"F");
        Facil pista = new Facil("esta es la pista");
        List<Edificio> edificios = new ArrayList<>();
        Edificio banco = new Edificio("Banco Nacional", pista);
        edificios.add(banco);
        Ciudad ciudad = new Ciudad("Montreal",edificios );

        Detective detective = new Detective(cronometro, ciudad, rango);
        assertEquals(pista, detective.visitar(banco));
    }

    /**Caso de uso 2
     * - Detective novato comienza en Montreal.
     * - Visita un Banco (nuevamente):
     *   - Se despliega una pista
     * - Visita una Biblioteca:
     *   -Se despliega una pista.
     */
    @Test public void test02DetectiveNovatoEmpiezaEnMontrealYAlVisitarVariosEdificiosDespliegaVariasPistas() {

        Cronometro cronometro = mock(Cronometro.class);
        Rango rango = new Novato();

        Facil pistaBanco = new Facil("esta es la pista del banco");
        Facil pistaBiblioteca = new Facil("esta es la pista del biblioteca");
        List<Edificio> edificios = new ArrayList<>();
        Edificio banco = new Edificio("Banco Nacional", pistaBanco);
        Edificio biblioteca = new Edificio("Biblioteca de Montreal", pistaBiblioteca);
        edificios.add(banco);
        edificios.add(biblioteca);
        Ciudad ciudad = new Ciudad("Montreal", edificios);

        Detective detective = new Detective(cronometro, ciudad, rango);
        assertEquals(pistaBanco, detective.visitar(banco));
        assertEquals(pistaBiblioteca, detective.visitar(biblioteca));
    }


    /**
     *Caso de uso 3
     * - Detective viaja de Montreal a México
     */
    @Test
    public void test03DetectiveViajaDeMontrealAMexico() {

        Cronometro cronometro = mock(Cronometro.class);

        Rango rango = new Novato();

        Ciudad montreal = new Ciudad("Montreal", new ArrayList<>());
        Ciudad mexico = new Ciudad("México", new ArrayList<>());

        Detective detective = new Detective(cronometro, montreal, rango);

        detective.viajar(montreal);

        verify(cronometro).restar(8);
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
        Facil pistaPuerto = new Facil("esta es la pista de la biblioteca pero en el puerto (?)");
        List<Edificio> edificios = new ArrayList<>();
        Edificio aeropuerto = new Edificio("Banco Nacional", pistaAeropuerto);
        Edificio puerto = new Edificio("Biblioteca de Montreal", pistaPuerto);
        edificios.add(aeropuerto);
        edificios.add(puerto);
        Ciudad montreal = new Ciudad("Montreal", edificios);

        Detective detective = new Detective(cronometro, montreal, rango);

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

//    /**Caso de uso 5
//     * - Detective sufre una herida de cuchillo.
//     * - Detective duerme.
//     */
//    @Test
//    public void detectiveSufreHeridaDeCuchilloYDuerme() {
//        assertEquals(1, 1);
//    }

}
