package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.modelo.DescripcionSospechoso;
import edu.fiuba.algo3.modelo.Rasgo;
import edu.fiuba.algo3.vista.VistaComputadora;
import edu.fiuba.algo3.vista.VistaPrincipal;

import java.util.List;

public class ComputadoraController {

    private final App app;
    private final VistaComputadora vistaComputadora;

    public ComputadoraController(App app, VistaComputadora vistaComputadora) {
        this.app = app;
        this.vistaComputadora = vistaComputadora;
    }

    public void volverAtras() {
        new VistaPrincipal(app);
    }

    public void buscar() {
        Juego.getInstance().cargarDatos(vistaComputadora);
    }

}
