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
    public void detectiveNovatoEmpiezaEnMontrealYAlVisitarBancoDespliegaUnaPista() {
        Ciudad ciudad = new Ciudad("Montreal");
        InterfazDeUsuario interfazMock = mock(InterfazDeUsuario.class);
        Detective detective = new Detective(ciudad);

        detective.visitar("Banco", interfazMock);

        // faltaría que reciba una pista
        verify(interfazMock).desplegar();
    }

//    /**Caso de uso 2
//     * - Detective novato comienza en Montreal.
//     * - Visita un Banco (nuevamente):
//     *   - Se despliega una pista
//     * - Visita una Biblioteca:
//     *   -Se despliega una pista.
//     */
//     @Test
//    public void detectiveNovatoEmpiezaEnMontrealYAlVisitarVariosEdificiosDespliegaVariasPistas() {
//         assertEquals(1, 1);
//    }

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
