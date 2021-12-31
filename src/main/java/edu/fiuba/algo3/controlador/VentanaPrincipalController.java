package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.vista.VistaComputadora;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaViajar;
import edu.fiuba.algo3.vista.VistaVisitar;

public class VentanaPrincipalController {
    private final App app;
    private final VistaPrincipal vistaPrincipal;

    public VentanaPrincipalController(App app, VistaPrincipal vistaPrincipal) {
        this.app = app;
        this.vistaPrincipal = vistaPrincipal;
    }

    public void computadora() {
        new VistaComputadora(app);
    }

    public void viajar() {
        vistaPrincipal.agregar(new VistaViajar());
    }

    public void visitar() {
        vistaPrincipal.agregar(new VistaVisitar());
    }

}
