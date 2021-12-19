package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.rango.Rango;

public class ContadorDeDificultad {
    private int cantidadDeArrestos;
    private Rango rango;

    public ContadorDeDificultad(Rango rangoInicial, int cantidadDeArrestos) {
        this.cantidadDeArrestos = cantidadDeArrestos;
        this.rango = rangoInicial.actualizar(cantidadDeArrestos);
    }

    public ContadorDeDificultad(Rango rangoInicial) {
        this.cantidadDeArrestos = 0;
        this.rango = rangoInicial.actualizar(0);
    }

    public void registrarArresto() {
        ++this.cantidadDeArrestos;
        this.rango = rango.actualizar(cantidadDeArrestos);
    }

    public int arrestos() {
        return cantidadDeArrestos;
    }

    public Rango rango() {
        return rango;
    }
}
