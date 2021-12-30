package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaPrincipal;

public class VentanaPrincipalController {
    private final VistaPrincipal vistaPrincipal;

    public VentanaPrincipalController(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }

    public void computadora() {
        System.out.println("computadora");
    }

    public void viajar() {
        System.out.println("viajar");
    }

    public void visitar() {
        System.out.println("visitar");
    }

}
