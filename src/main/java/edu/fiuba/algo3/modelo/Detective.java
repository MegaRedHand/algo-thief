package edu.fiuba.algo3.modelo;

public class Detective {
    private Ciudad ciudadActual;

    public Detective(Ciudad ciudad) {
        this.ciudadActual = ciudad;
    }

    public void visitar(String nombreEdificio, InterfazDeUsuario interfaz) {
        interfaz.desplegar();
    }
}
