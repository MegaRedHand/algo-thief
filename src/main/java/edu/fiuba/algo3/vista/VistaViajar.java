package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.controlador.BotonCiudadController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.util.List;

public class VistaViajar extends VistaBotonera {

    public VistaViajar() {
        super("/vistas/botonEdificio.fxml");
    }

    @Override
    protected EventHandler<ActionEvent> crearControlador(Label label, String nombre) {
        return new BotonCiudadController(this, label, nombre);
    }

    @Override
    protected List<String> getNombres() {
        return Juego.getInstance().ciudadesVisitables();
    }
}
