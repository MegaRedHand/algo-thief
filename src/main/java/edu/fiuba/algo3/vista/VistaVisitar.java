package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controlador.BotonEdificioController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VistaVisitar extends VistaBotonera {

    public VistaVisitar() {
        super("/vistas/botonEdificio.fxml");
    }

    @Override
    protected EventHandler<ActionEvent> crearControlador(Label label, String nombre) {
        return new BotonEdificioController(label, nombre);
    }

    @Override
    protected List<String> getNombres() {
        return Juego.getInstance().edificiosVisitables();
    }
}
