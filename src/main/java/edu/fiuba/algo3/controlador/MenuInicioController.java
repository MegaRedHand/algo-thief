package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaVisitar;
import javafx.fxml.FXMLLoader;
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

        VistaPrincipal vistaPrincipal = new VistaPrincipal(app);

        VistaVisitar vistaVisitar = new VistaVisitar();

        vistaPrincipal.agregar(vistaVisitar);
    }

}
