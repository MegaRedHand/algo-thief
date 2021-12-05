package edu.fiuba.algo3.modelo;

public class Ladron {
    private String genero;
    private ObjetoRobado objetoRobado;

    public void Ladron(ObjetoRobado objeto, String genero) {
        this.genero = genero;
        this.objetoRobado = objeto;
    }
}