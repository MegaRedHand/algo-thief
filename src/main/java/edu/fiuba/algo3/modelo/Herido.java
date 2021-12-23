package edu.fiuba.algo3.modelo;

public class Herido implements Salud {

    @Override
    public int tiempoDeRecuperacion() {
        return 1;
    }

    @Override
    public Salud recibirHeridaDeCuchillo() {
        return this;
    }

}
