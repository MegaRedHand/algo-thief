package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega2Test {

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

    /**
     * Caso de uso 1
     * - Detective sufre una herida de cuchillo.
     * - Detective duerme.
     */
    @Test
    public void test01DetectiveSufreHeridaDeCuchilloYDuerme() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));
        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        Cronometro cronometro = new Cronometro(7);

        EscenarioBuilderManual builder = new EscenarioBuilderManual().conCronometro(cronometro);
        builder.conLadron(new Ladron("Carmen SanDiego", new DescripcionSospechoso()));
        builder.conCiudades(new CiudadBuilder(datosMexico));

        algothief.generarEscenario(builder);

        algothief.recibirHeridaDeCuchillo();
        algothief.dormir();

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(17, cronometro.fechaActual().getHour());
    }

    /**
     * Caso de uso 2
     * - Detective con rango Investigador toma caso de un robo viaja de Montreal a México
     */
    @Test
    public void test02DetectiveInvestigadorTomaCasoYViajaDeMontrealAMexico() {

        Algothief algothief = new Algothief(mock(FuenteDeDatos.class));
        algothief.asignarDetective(new ContadorDeDificultad(new Investigador(), 10));

        Cronometro cronometro = new Cronometro(7);
        EscenarioBuilderManual builder = new EscenarioBuilderManual().conCronometro(cronometro);

        builder.conLadron(new Ladron("Carmen SanDiego", new DescripcionSospechoso()));
        builder.conCiudades(
                new CiudadBuilder(datosMontreal),
                new CiudadBuilder(datosMexico)
        );

        algothief.generarEscenario(builder);

        algothief.viajar("Mexico");

        int distanciaEntreCiudades = 3800; // km
        int tiempoEsperado = new Investigador().tiempoDeViaje(distanciaEntreCiudades);

        assertEquals(DayOfWeek.MONDAY, cronometro.fechaActual().getDayOfWeek());
        assertEquals(7 + tiempoEsperado, cronometro.fechaActual().getHour());
    }

    /**
     * Caso de uso 3
     * - Cargar en la computadora los datos recopilados y buscar sospechosos.
     */
    @Test
    public void test03DetectiveCargaDatosEnComputadoraYBuscaSospechoso() {

        FuenteDeDatos fuente = mock(FuenteDeDatos.class);

        Ladron ladron1 = new Ladron("Carmen SanDiego", new DescripcionSospechoso(
                new Rasgo("Sexo", "Femenino"),
                new Rasgo("Hobby", "Tenis")
        ));
        Ladron ladron2 = new Ladron("Lucía", new DescripcionSospechoso(
                new Rasgo("Sexo", "Femenino"),
                new Rasgo("Hobby", "Alpinismo")
        ));

        when(fuente.getComputadora()).thenReturn(new Computadora(List.of(ladron1, ladron2)));

        Algothief algothief = new Algothief(fuente);
        algothief.asignarDetective(new ContadorDeDificultad(new Investigador(), 10));

        Cronometro cronometro = new Cronometro(7);
        EscenarioBuilderManual builder = new EscenarioBuilderManual().conCronometro(cronometro);
        builder.conLadron(ladron1);
        builder.conCiudades(new CiudadBuilder(datosMontreal));

        algothief.generarEscenario(builder);

        DescripcionSospechoso descripcion = new DescripcionSospechoso(
                new Rasgo("Hobby", "Tenis"),
                new Rasgo("Sexo", "Femenino"));
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

        Cronometro cronometro = new Cronometro(7);
        EscenarioBuilderManual builder = new EscenarioBuilderManual().conCronometro(cronometro);
        builder.conLadron(new Ladron("Carmen", new DescripcionSospechoso()));
        builder.conCiudades(new CiudadBuilder(Map.of("ciudad", "Montreal")));

        algothief.generarEscenario(builder);

        algothief.atraparSospechoso();

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

        FuenteDeDatos fuente = mock(FuenteDeDatos.class);

        Ladron ladron1 = new Ladron("Carmen SanDiego", new DescripcionSospechoso(
                new Rasgo("sexo", "Femenino"),
                new Rasgo("hobby", "Tenis")
        ));
        Ladron ladron2 = new Ladron("Lucía", new DescripcionSospechoso(
                new Rasgo("sexo", "Femenino"),
                new Rasgo("hobby", "Alpinismo")
        ));

        when(fuente.getComputadora()).thenReturn(new Computadora(List.of(ladron1, ladron2)));

        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        builder.conCronometro(new Cronometro(7));

        builder.conObjetoRobado(new Comun("Incan Gold Mask", "Montreal"));
        builder.conLadron(ladron1);

        builder.conCiudades(
                new CiudadBuilder(datosMontreal).conEdificios(
                        new BancoBuilder(),
                        new BibliotecaBuilder()
                ),
                new CiudadBuilder(datosMexico).conEdificios(
                        new AeropuertoBuilder(),
                        new PuertoBuilder()
                )
        );

        algothief.generarEscenario(builder);

        algothief.visitar("Banco de Montreal");
        algothief.visitar("Banco de Montreal");
        algothief.visitar("Biblioteca de Montreal");

        algothief.viajar("Mexico");
        algothief.visitar("Aeropuerto de Mexico");

        DescripcionSospechoso descripcion = new DescripcionSospechoso(
                new Rasgo("hobby", "Tenis"),
                new Rasgo("sexo", "Femenino")
        );
        algothief.cargarDatosSospechoso(descripcion);
        algothief.buscarSospechosos();

        algothief.atraparSospechoso();

        assertTrue(algothief.juegoAcabado());
        assertTrue(algothief.juegoGanado());
    }

}
