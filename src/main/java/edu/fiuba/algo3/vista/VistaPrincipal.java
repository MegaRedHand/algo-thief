package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controlador.VentanaPrincipalController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public class VistaPrincipal {

    private VBox root = null;

    public VistaPrincipal(App app) {
        URL url = SystemInfo.getResourceURL("/vistas/ventanaPrincipal.fxml");
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(new VentanaPrincipalController(this));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        app.loadScene(root);
    }

    public void agregar(VistaBotonera vistaBotonera) {
        vistaBotonera.agregarse((HBox) root.lookup("#botoneraOpciones"), (Label) root.lookup("#labelDescripcion"));
    }

}
