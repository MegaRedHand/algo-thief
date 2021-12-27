package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.perifericos.LectorDeArchivos;

public class Juego {

    Algothief algothief = new Algothief(new LectorDeArchivos());
    private static final Juego singleton = new Juego();

    private Juego() {}

    public static Juego getInstance() {
        return singleton;
    }

}
