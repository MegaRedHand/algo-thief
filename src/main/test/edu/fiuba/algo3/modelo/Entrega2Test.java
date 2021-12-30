package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega2Test {

    // los datos son de Atenas en realidad
    private final Map<String, ?> datosMontreal = Map.ofEntries(
            entry("ciudad", "Montreal"),
            entry("colorBandera", List.of("Azul" , "Blanco")),
            entry("moneda", "Dracmas"),
            entry("geografia", "Montes"),
            entry("caracteristicas", List.of("Mar Egeo", "Cordillera de Pindo")),
            entry("industrias", List.of("Higos", "Olivas")),
            entry("animales", List.of("Cabra montesa blanca")),
            entry("etnias", List.of("Plateo" , "Espartanos")),
            entry("idiomas", List.of("Griego")),
            entry("arte", "Estatua de Zeus"),
            entry("religion", "Cristianismo"),
            entry("representante", "Primer Ministro"),
            entry("otros", List.of("República Helénica, Frontera con Yugoslavia")),
            entry("latitud", 37.984167),
            entry("longitud", 23.728056),
            entry("descripcion", "La historia de Atenas se extiende más de tres mil años, lo que la convierte en una de las ciudades habitadas más antiguas. Durante la época clásica de Grecia, fue una poderosa ciudad-estado que nació junto con el desarrollo de la navegación marítima del puerto de El Pireo y que tuvo un papel fundamental en el desarrollo de la democracia. También fue un centro cultural donde vivieron muchos de los grandes artistas, escritores y filósofos de la Antigüedad. Estas contribuciones de Atenas al pensamiento de su época tuvieron una gran influencia en el desarrollo de Grecia, de Roma y de la cultura occidental.")
    );
    // los datos son de Baghdad en realidad
    private final Map<String, ?> datosMexico = Map.ofEntries(
            entry("ciudad", "Mexico"),
            entry("colorBandera", List.of("Rojo", "Blanco", "Negro")),
            entry("moneda", "Dinares"),
            entry("geografia", "Desierto"),
            entry("caracteristicas", List.of("Desierto Sirio", "Río Eufrates", "Río Tigris")),
            entry("industrias", List.of("Petroleo")),
            entry("animales", List.of("Gacelas árabes")),
            entry("etnias", List.of("Sumerio", "Bagdadi")),
            entry("idiomas", List.of("Arabe")),
            entry("arte", "Puertas de Baghdad"),
            entry("religion", "Islam"),
            entry("representante", "Presidente"),
            entry("otros", "Mesopotamia"),
            entry("latitud", 33.35),
            entry("longitud", 44.416667),
            entry("descripcion", "Ubicada a orillas del río Tigris, la ciudad fue fundada en el siglo viii y se convirtió en capital del Califato abasí. En poco tiempo se convirtió en un centro cultural, comercial e intelectual de gran relevancia del mundo islámico. Esto, y el hecho de ser sede de varias instituciones académicas relevantes, como la Casa de la sabiduría, le sirvieron a la ciudad para ganarse una reputación mundial de «Centro de Enseñanza». Bagdad fue la ciudad más grande de la Edad Media durante gran parte del Califato abasí, cuando alcanzó un pico de un millón y medio de habitantes. Sin embargo, la urbe fue en gran parte destruida por las tropas del Imperio mongol en 1258, lo que resultó en un declive que se prolongaría por muchos siglos debido a frecuentes epidemias y la sucesión de varios imperios que dominaron la ciudad. Con el reconocimiento de Irak como estado independiente en 1938 tras la desaparición del Mandato Británico para Mesopotamia, Bagdad recuperó gradualmente parte de su pasada preeminencia como centro significante de la cultura musulmana.")
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

        Coordenadas coordenadasMontreal = new Coordenadas(
                Double.parseDouble(datosMontreal.get("latitud").toString()),
                Double.parseDouble(datosMontreal.get("longitud").toString())
        );
        Coordenadas coordenadasMexico = new Coordenadas(
                Double.parseDouble(datosMexico.get("latitud").toString()),
                Double.parseDouble(datosMexico.get("longitud").toString())
        );

        int distanciaEntreCiudades = Double.valueOf(coordenadasMontreal.distanciaA(coordenadasMexico)).intValue();
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
        builder.conCiudades(new CiudadBuilder(datosMontreal));

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
