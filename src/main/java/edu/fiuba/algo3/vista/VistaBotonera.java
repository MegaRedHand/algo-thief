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
import java.net.URL;
import java.util.List;

public abstract class VistaBotonera {

    private HBox botonera;
    private Label label;
    private final String pathFxmlBoton;

    protected VistaBotonera(String pathFxmlBoton) {
        this.pathFxmlBoton = pathFxmlBoton;
    }

    public void agregarse(HBox botonera, Label label) {
        this.botonera = botonera;
        this.label = label;

        botonera.getChildren().clear();

        URL urlBoton = SystemInfo.getResourceURL(pathFxmlBoton);

        List<String> nombresBotones = getNombres();

        for (String nombre: nombresBotones) {
            Button boton = null;
            try {
                FXMLLoader loader = new FXMLLoader(urlBoton);
                boton = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            boton.setText(nombre);
            boton.setOnAction(crearControlador(label, nombre));
            botonera.getChildren().add(boton);
        }
    }

    public void actualizarBotones() {
        this.agregarse(botonera, label);
    }

    protected abstract EventHandler<ActionEvent> crearControlador(Label label, String nombre);

    protected abstract List<String> getNombres();

}
