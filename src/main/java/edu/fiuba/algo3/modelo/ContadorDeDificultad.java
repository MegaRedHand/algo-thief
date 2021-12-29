package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

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


    public List<ObjetoRobado> obtenerObjetosRobados(FuenteDeDatos fuente) {
        if (cantidadDeArrestos < 7) {
            return new ArrayList<>(fuente.obtenerObjetosComunes());
        } else if (cantidadDeArrestos < 14) {
            return new ArrayList<>(fuente.obtenerObjetosValiosos());
        }
        return new ArrayList<>(fuente.obtenerObjetosMuyValiosos());
    }

}
