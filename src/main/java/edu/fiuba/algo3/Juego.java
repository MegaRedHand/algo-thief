package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.ContadorDeDificultad;
import edu.fiuba.algo3.modelo.Novato;
import edu.fiuba.algo3.modelo.RandomBuilder;
import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import edu.fiuba.algo3.perifericos.LectorJson;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class Juego {

    private final Algothief algothief;
    private static final Juego singleton = new Juego();

    private Juego() {
        URL pathCiudades = SystemInfo.getResourceURL("/datos/ciudades.json");
        URL pathLadrones = SystemInfo.getResourceURL("/datos/ladrones.json");
        URL pathObjetos = SystemInfo.getResourceURL("/datos/objetos.json");

        Map<String, LectorJson> lectores = Map.of(
                "ciudades", new LectorJson(pathCiudades.getPath()),
                "ladrones", new LectorJson(pathLadrones.getPath()),
                "objetos", new LectorJson(pathObjetos.getPath())
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

    public void visitar(String nombreEdificio) {
        algothief.visitar(nombreEdificio);
    }

    public void viajar(String nombreCiudad) {
        algothief.viajar(nombreCiudad);
    }

    public List<String> edificiosVisitables() {
        return algothief.edificiosVisitables();
    }

    public String ultimaPista() {
        return algothief.pistaMasReciente();
    }
}
