package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega1Test {

    // los datos son de Atenas en realidad
    Map<String, ?> datosMontreal = Map.ofEntries(
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
    Map<String, ?> datosMexico = Map.ofEntries(
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
                new CiudadBuilder(datosMontreal).conEdificios(
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

        Pista pistaBiblioteca = new GeneradorDePistasBiblioteca().generarPistaFacil(datosMexico, descripcion);

        Algothief algothief = new Algothief(fuente);

        algothief.asignarDetective(new ContadorDeDificultad(new Novato(), 0));

        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        Cronometro cronometro = new Cronometro(7);
        builder.conCronometro(cronometro);
        builder.conLadron(new Ladron("Carmen SanDiego", descripcion));

        builder.conCiudades(
                new CiudadBuilder(datosMontreal).conEdificios(
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

        Coordenadas coordenadasMontreal = new Coordenadas(
                Double.parseDouble(datosMontreal.get("latitud").toString()),
                Double.parseDouble(datosMontreal.get("longitud").toString())
        );
        Coordenadas coordenadasMexico = new Coordenadas(
                Double.parseDouble(datosMexico.get("latitud").toString()),
                Double.parseDouble(datosMexico.get("longitud").toString())
        );

        int distanciaEntreCiudades = coordenadasMontreal.distanciaA(coordenadasMexico);
        int tiempoEsperado = new Novato().tiempoDeViaje(distanciaEntreCiudades);

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

        Pista pistaAeropuerto = new GeneradorDePistasAeropuerto().generarPistaFacil(datosMontreal, descripcion);

        Pista pistaPuerto = new GeneradorDePistasPuerto().generarPistaFacil(datosMontreal, descripcion);

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
