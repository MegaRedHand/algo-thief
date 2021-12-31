package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.vista.VistaViajar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BotonCiudadController implements EventHandler<ActionEvent> {

    private final VistaViajar vista;
    private final Label label;
    private final String nombreCiudad;

    public BotonCiudadController(VistaViajar vista, Label label, String nombreCiudad) {
        this.vista = vista;
        this.label = label;
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(actionEvent.getTarget().toString());
        Juego.getInstance().viajar(nombreCiudad, label);
        vista.actualizarBotones();
   }

}
