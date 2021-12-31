package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.MenuInicioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        URL url = SystemInfo.getResourceURL("/vistas/ventanaInicio.fxml");
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(new MenuInicioController(this));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadScene(root);
    }

    public void loadScene(Parent parent) {
        Scene scene = new Scene(parent, 600, 400);

        stage.setTitle("AlgoThief");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}