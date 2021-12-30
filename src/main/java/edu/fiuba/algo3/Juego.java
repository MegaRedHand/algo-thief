package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.ContadorDeDificultad;
import edu.fiuba.algo3.modelo.Novato;
import edu.fiuba.algo3.modelo.RandomBuilder;
import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import edu.fiuba.algo3.perifericos.LectorJson;

import java.net.URL;
import java.util.Map;

public class Juego {

    private final Algothief algothief;
    private static final Juego singleton = new Juego();

    private Juego() {
        URL pathCiudades = getClass().getResource("/datos/ciudades.json");
        URL pathLadrones = getClass().getResource("/datos/ciudades.json");
        URL pathObjetos = getClass().getResource("/datos/ciudades.json");
        Map<String, LectorJson> lectores = Map.of(
                "ciudades", new LectorJson(pathCiudades.toString()),
                "ladrones", new LectorJson(pathLadrones.toString()),
                "objetos", new LectorJson(pathObjetos.toString())
        );
        algothief = new Algothief(new LectorDeArchivos(lectores));
        algothief.asignarPolicia(new ContadorDeDificultad(new Novato(), 0));
    }

    public static Juego getInstance() {
        return singleton;
    }

    public void comenzarJuego() {
        algothief.generarEscenario(new RandomBuilder());
    }

}
