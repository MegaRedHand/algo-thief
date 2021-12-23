package edu.fiuba.algo3.modelo;

public class Saludable implements Salud {

    @Override
    public int tiempoDeRecuperacion() {
        return 2;
    }

    @Override
    public Salud recibirHeridaDeCuchillo() {
        return new Herido();
    }
}
