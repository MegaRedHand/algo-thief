package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.perifericos.LectorDeArchivos;

import java.util.Map;

public class Juego {
    private Map<String,String> rutasArchivos;

    Algothief algothief = new Algothief(new LectorDeArchivos(this.rutasArchivos));
    private static final Juego singleton = new Juego();

    private Juego() {}

    public static Juego getInstance() {
        return singleton;
    }

}
