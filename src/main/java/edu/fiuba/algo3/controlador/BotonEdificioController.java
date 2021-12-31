package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BotonEdificioController implements EventHandler<ActionEvent> {

    private final Label label;
    private final String nombreEdificio;

    public BotonEdificioController(Label label, String nombreEdificio) {
        this.label = label;
        this.nombreEdificio = nombreEdificio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().visitar(nombreEdificio, label);
    }

}
