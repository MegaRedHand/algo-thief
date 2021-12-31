package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controlador.VistaFinalController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;

public class VistaFinalPartida {

    public VistaFinalPartida(App app, String resultado) {
        URL url = SystemInfo.getResourceURL("/vistas/ventanaFinalJuego.fxml");
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(new VistaFinalController(app));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((Label) root.lookup("#resultado")).setText(resultado);
        app.loadScene(root);
    }

}
