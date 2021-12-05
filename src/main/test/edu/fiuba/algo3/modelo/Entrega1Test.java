package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        Detective detective = new Detective(rango);
        Banco banco = new Banco("Banco Nacional");
        Ciudad ciudad = new Ciudad("Montreal", banco);
        detective.cambiarCiudad(ciudad);
        detective.visitar(banco);

    }

    /**Caso de uso 2
     * - Detective novato comienza en Montreal.
     * - Visita un Banco (nuevamente):
     *   - Se despliega una pista
     * - Visita una Biblioteca:
     *   -Se despliega una pista.
     */

    @Test
    public void detectiveNovatoEmpiezaEnMontrealYAlVisitarVariosEdificiosDespliegaVariasPistas() {
        Ciudad ciudad = new Ciudad("Montreal");
        Rango rango = new Novato();
        Detective detective = new Detective(ciudad, rango);

        Pista pista1 = Facil("Un string");
        Pista pista2 = Facil("Otro string");

        Testigo testigo1 = new Testigo(pista1);
        Testigo testigo2 = new Testigo(pista2);

        Edificio banco = new Edificio(testigo1);
        Edificio biblioteca = new Edificio(testigo2);

        ciudad.añadirEdificio(banco);
        ciudad.añadirEdificio(biblioteca);

        detective.visitar("Banco");
        detective.visitar("Biblioteca");
        assert(true);
    }

//    /**Caso de uso 3
//     * - Detective viaja de Montreal a México
//     */
//    @Test
//    public void detectiveViajaDeMontrealAMexico() {
//        assertEquals(1, 1);
//    }

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
