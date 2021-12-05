package edu.fiuba.algo3.modelo;

public class Detective {
    private Ciudad ciudadActual;
    private Rango rango;

    public Detective(Ciudad ciudad, Rango rango) {
        this.ciudadActual = ciudad;
        this.rango = rango;
    }

    public void visitar(String nombreEdificio, InterfazDeUsuario interfaz) {
        interfaz.desplegar();
        rango.visitarEdificio(nombreEdificio);
    }
}