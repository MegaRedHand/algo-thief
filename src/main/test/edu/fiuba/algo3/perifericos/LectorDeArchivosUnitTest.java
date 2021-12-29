package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LectorDeArchivosUnitTest {

    private final Map<String, String> rutas = Map.of(
            "ciudades","archivos/ciudades.json",
            "ladrones","archivos/ladrones.json",
            "objetos","archivos/objetos.json"
    );
    
    private final List<Map<String, ?>> datosCiudades = List.of(
            Map.ofEntries(
                    entry("ciudad", "Atenas"),
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
            ),
            Map.ofEntries(
                    entry("ciudad", "Baghdad"),
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
            ));

    private final List<Map<String, ?>> datosLadrones = List.of(
            Map.of(
                    "nombre", "Carmen Sandiego",
                    "sexo", "Femenino",
                    "ocupacion", "Antigua agente del Servicio de Espionaje de Mónaco",
                    "hobby", "Tenis",
                    "colorDelPelo", "Castaño",
                    "coche", "Descapotable Packard 1939",
                    "señasParticulares", "Jamás se muestra en público sin su collar de rubíes",
                    "otros", "Le encanta la enchilada"
            ),
            Map.of(
                    "nombre", "Merey LaRoc",
                    "sexo", "Femenino",
                    "ocupacion", "Bailarina profesional de aerobic",
                    "hobby", "Alpinismo",
                    "colorDelPelo", "Castaño",
                    "coche", "Limusina de lujo",
                    "señasParticulares", "Siempre lleva unas joyas muy elegantes",
                    "otros", "Le encanta la comida picante"
            ));

    private final List<Map<String, ?>> objetosRobados = List.of(
            Map.of(
                    "ciudad", "Baghdad",
                    "tesoro", "Tablilla babilónica",
                    "valor", "Comun"
            ),
            Map.of(
                    "ciudad", "Peking",
                    "tesoro", "Huevo de 1000 años",
                    "valor", "Valioso"
            ),
            Map.of(
                    "ciudad", "Baghdad",
                    "tesoro", "Alfombra voladora",
                    "valor", "Muy valioso"
            ));
    
    @Test
    public void test01seLeeLaCiudadCorrectamente() {
        LectorJson lectorStub = mock(LectorJson.class);
        when(lectorStub.leerJson(rutas.get("ciudades"))).thenReturn(datosCiudades);
        LectorDeArchivos lector = new LectorDeArchivos(rutas, lectorStub);

        List<CiudadBuilder> ciudadBuilders = lector.crearCiudadBuilders();

        assertEquals(2, ciudadBuilders.size());
        assertTrue(ciudadBuilders.get(0).lePertenece(new Comun("nombre", datosCiudades.get(0).get("ciudad").toString())));
        assertTrue(ciudadBuilders.get(1).lePertenece(new Comun("nombre", datosCiudades.get(1).get("ciudad").toString())));
    }

    @Test
    public void test02seLeeLosLadronesCorrectamente() {
        LectorJson lectorStub = mock(LectorJson.class);
        when(lectorStub.leerJson(rutas.get("ladrones"))).thenReturn(datosLadrones);
        LectorDeArchivos lector = new LectorDeArchivos(rutas, lectorStub);
        
        List<Ladron> ladrones = lector.getComputadora().listaDeLadrones();

        assertEquals(2, ladrones.size());
        assertTrue(ladrones.get(0).seLlama(datosLadrones.get(0).get("nombre").toString()));
        assertTrue(ladrones.get(1).seLlama(datosLadrones.get(1).get("nombre").toString()));
    }

    @Test
    public void test03seLeenLosObjetosCorrectamente() {
        LectorJson lectorStub = mock(LectorJson.class);
        when(lectorStub.leerJson(rutas.get("objetos"))).thenReturn(objetosRobados);
        LectorDeArchivos lector = new LectorDeArchivos(rutas, lectorStub);

        List<Comun> comunes = List.of(new Comun(
                objetosRobados.get(0).get("tesoro").toString(),
                objetosRobados.get(0).get("ciudad").toString()
        ));

        assertEquals(comunes, lector.obtenerObjetosComunes());
    }

}
