package edu.fiuba.algo3.modelo;

import java.util.Locale;

public class Rasgo {

    private final String categoria;
    private final String valor;

    public Rasgo(String categoria, String valor) {
        this.categoria = categoria;
        this.valor = valor;
    }

    public String categoria() {
        return this.categoria;
    }

    public boolean igualA(Rasgo otroRasgo) {
        return this.valor.toLowerCase(Locale.ROOT).equals(otroRasgo.valor.toLowerCase(Locale.ROOT));
    }

    @Override
    public String toString() {
        return valor;
    }
}
