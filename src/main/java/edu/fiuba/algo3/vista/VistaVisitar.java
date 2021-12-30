package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.controlador.BotonEdificioController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VistaVisitar implements VistaBotonera {

    public void agregarse(HBox botonera, Label label) {
        URL urlBoton = getClass().getResource("/vistas/botonEdificio.fxml");
        List<String> nombresEdificios = Juego.getInstance().edificiosVisitables();

        for (String nombre: nombresEdificios) {
            Button boton = null;
            try {
                FXMLLoader loader = new FXMLLoader(urlBoton);
                boton = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            boton.setText(nombre);
            boton.setOnAction(new BotonEdificioController(label, nombre));
            botonera.getChildren().add(boton);
        }
    }

}
