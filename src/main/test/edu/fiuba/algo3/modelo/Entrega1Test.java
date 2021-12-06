package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    public void test01detectiveNovatoEmpiezaEnMontrealYAlVisitarBancoDespliegaUnaPista() {

        Rango rango = new Novato();
        Comun objeto = new Comun("Tesoro Nacional de Montreal");
        Ladron ladron = new Ladron(objeto,"F");
        Facil pista = new Facil("esta es la pista");
        List<Edificio> edificios = new ArrayList<>();
        Edificio banco = new Edificio("Banco Nacional", pista);
        edificios.add(banco);
        Ciudad ciudad = new Ciudad("Montreal",edificios );

        Detective detective = new Detective(ciudad, rango);
        assertEquals(pista, detective.visitar(banco));
    }

    /**Caso de uso 2
     * - Detective novato comienza en Montreal.
     * - Visita un Banco (nuevamente):
     *   - Se despliega una pista
     * - Visita una Biblioteca:
     *   -Se despliega una pista.
     */


    @Test public void test02detectiveNovatoEmpiezaEnMontrealYAlVisitarVariosEdificiosDespliegaVariasPistas() {
        Rango rango = new Novato();

        Facil pistaBanco = new Facil("esta es la pista del banco");
        Facil pistaBiblioteca = new Facil("esta es la pista del biblioteca");
        List<Edificio> edificios = new ArrayList<>();
        Edificio banco = new Edificio("Banco Nacional", pistaBanco);
        Edificio biblioteca = new Edificio("Biblioteca de Montreal", pistaBiblioteca);
        edificios.add(banco);
        edificios.add(biblioteca);
        Ciudad ciudad = new Ciudad("Montreal", edificios);

        Detective detective = new Detective(ciudad, rango);
        assertEquals(pistaBanco, detective.visitar(banco));
        assertEquals(pistaBiblioteca, detective.visitar(biblioteca));
    }


   /*
    *Caso de uso 3
    * - Detective viaja de Montreal a México
    */
   @Test
    public void test03detectiveViajaDeMontrealAMexico() {


}

//    /**Caso de uso 4
//     * - Visita un Aeropuerto (3 veces):
//     *   - Se despliega una pista.
//     * - Visita un Puerto (55 veces):
//     *   - Se despliega una pista.
//     */
//    @Test
//    public void detectiveAlVisitaAeropuertoSeDespliegaPistaYAlVisitarPuertoSeDespliegaPista() {
//        assertEquals(1, 1);
//    }

//    /**Caso de uso 5
//     * - Detective sufre una herida de cuchillo.
//     * - Detective duerme.
//     */
//    @Test
//    public void detectiveSufreHeridaDeCuchilloYDuerme() {
//        assertEquals(1, 1);
//    }

}
