package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.Juego;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MenuInicioController {

    private final App app;

    public MenuInicioController(App app) {
        this.app = app;
    }

    public void comenzarPartida() {
        Juego.getInstance().comenzarJuego();
        URL url = getClass().getResource("/vistas/ventanaPrincipal.fxml");
        VBox root = null;
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(new VentanaPrincipalController(app));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HBox botonera = ((HBox) root.lookup("#botoneraOpciones"));

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
            boton.setOnAction(new BotonEdificioController((Label)root.lookup("#labelDescripcion"), nombre));
            botonera.getChildren().add(boton);
        }

        app.loadScene(root);
    }

}
