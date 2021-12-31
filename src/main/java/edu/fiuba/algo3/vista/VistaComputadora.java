package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controlador.ComputadoraController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class VistaComputadora {

    private VBox root = null;

    public VistaComputadora(App app) {
        URL url = SystemInfo.getResourceURL("/vistas/ventanaComputadora.fxml");
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(new ComputadoraController(app, this));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        app.loadScene(root);
    }

    private String getTextoLabel(String id) {
        return ((TextField) root.lookup(id)).getText().toLowerCase(Locale.ROOT);
    }

    public String getSexo() {
        return getTextoLabel("#sexo");
    }

    public String getHobby() {
        return getTextoLabel("#hobby");
    }

    public String getVehiculo() {
        return getTextoLabel("#vehiculo");
    }

    public String getCabello() {
        return getTextoLabel("#cabello");
    }

    public void setTextoLabel(String texto) {
        ((Label) root.lookup("#labelSuperior")).setText(texto);
    }
}
