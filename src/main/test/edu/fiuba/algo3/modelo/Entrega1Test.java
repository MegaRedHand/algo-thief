package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega1Test {

    Map<String, ?> datosMontreal = Map.of(
            "ciudad", "Montreal",
            "moneda", "Dracmas",
            "geografia", "Montes",
            "caracteristicas", List.of("Mar Egeo", "Cordillera de Pindo"),
            "industrias", List.of("Higos", "Olivas"),
            "etnias", List.of("Plateo" , "Espartanos"),
            "idiomas", List.of("Griego"),
            "otros", List.of("República Helénica, Frontera con Yugoslavia"),
            "latitud", 37.984167,
            "longitud", 23.728056
    );
    Map<String, ?> datosMexico = Map.of(
            "ciudad", "Mexico",
            "moneda", "Dinares",
            "geografia", "Montes",
            "caracteristicas", List.of("Mar Egeo", "Cordillera de Pindo"),
            "industrias", List.of("Higos", "Olivas"),
            "etnias", List.of("Plateo" , "Espartanos"),
            "idiomas", List.of("Griego"),
            "otros", List.of("República Helénica, Frontera con Yugoslavia"),
            "latitud", 33.35,
            "longitud", 44.416667
    );

    DescripcionSospechoso descripcion = new DescripcionSospechoso(
            new Rasgo("sexo", "Femenino"),
            new Rasgo("vehiculo", "Deportivo")
    );

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

        Pista pista = new GeneradorDePistasBanco().generarPistaFacil(datosMexico, descripcion);

        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        builder.conCronometro(new Cronometro(0));
        builder.conLadron(new Ladron("Carmen SanDiego", descripcion));

        builder.conObjetoRobado(new Comun("Tesoro Nacional de Montreal", "Montreal"));
        builder.conLadron(new Ladron("Sospechoso", descripcion));
        builder.conCiudades(
                new CiudadBuilder(Map.of("ciudad", "Montreal")).conEdificios(
                        new BancoBuilder()
                ).conPistasPara(new CiudadBuilder(datosMexico))
        );

        algothief.generarEscenario(builder);

        algothief.visitar("Banco de Montreal");
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

        Pista pistaBanco = new GeneradorDePistasBanco().generarPistaFacil(datosMexico, descripcion);

        Pista pistaBiblioteca = new GeneradorDePistasBanco().generarPistaFacil(datosMexico, descripcion);

        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        Cronometro cronometro = new Cronometro(7);
        builder.conCronometro(cronometro);
        builder.conLadron(new Ladron("Carmen SanDiego", descripcion));

        builder.conCiudades(
                new CiudadBuilder(Map.of("ciudad", "Montreal")).conEdificios(
                        new BancoBuilder(),
                        new BibliotecaBuilder()
                ).conPistasPara(new CiudadBuilder(datosMexico))
        );

        algothief.generarEscenario(builder);

        algothief.visitar("Banco de Montreal");
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
        builder.conLadron(new Ladron("Carmen SanDiego", descripcion));

        builder.conCiudades(
                new CiudadBuilder(datosMontreal),
                new CiudadBuilder(datosMexico)
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

        Pista pistaAeropuerto = new GeneradorDePistasBanco().generarPistaFacil(datosMontreal, descripcion);

        Pista pistaPuerto = new GeneradorDePistasBanco().generarPistaFacil(datosMontreal, descripcion);

        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        Cronometro cronometro = new Cronometro(7);
        EscenarioBuilderManual builder = new EscenarioBuilderManual().conCronometro(cronometro);
        builder.conLadron(new Ladron("Carmen SanDiego", descripcion));


        String nombreAeropuerto = "Aeropuerto de Mexico";
        String nombrePuerto = "Puerto de Mexico";

        builder.conCiudades(
                new CiudadBuilder(datosMexico).conEdificios(
                        new AeropuertoBuilder(),
                        new PuertoBuilder()
                ).conPistasPara(new CiudadBuilder(datosMontreal))
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
        builder.conLadron(new Ladron("Carmen SanDiego", descripcion));
        builder.conCiudades(new CiudadBuilder(datosMexico));

        algothief.generarEscenario(builder);

        algothief.recibirHeridaDeCuchillo();
        algothief.dormir();

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(17, cronometro.fechaActual().getHour());
    }

}
