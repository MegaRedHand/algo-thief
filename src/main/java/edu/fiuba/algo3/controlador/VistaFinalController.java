package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.vista.VistaFinalPartida;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaViajar;

public class VistaFinalController {
    private final App app;

    public VistaFinalController(App app) {
        this.app = app;
    }

    public void continuar() {
        Juego.getInstance().comenzarJuego();
        new VistaPrincipal(app);
    }

}
