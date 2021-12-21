package edu.fiuba.algo3.modelo;

import java.util.Map;

public class BancoBuilder extends EdificioBuilder {

    String nombreEdificio;

    public BancoBuilder(String nombreCiudad) {
        super("Banco nacional de " + nombreCiudad);
        this.nombreEdificio = "Banco nacional de " + nombreCiudad;
    }

    public Edificio construirCon(Rango rango, Map<String, ?> datosSiguienteCiudad) {
        return new Edificio(nombreEdificio, new Pista("La moneda del siguiente país es " + datosSiguienteCiudad.get("Currency").toString()));
    }

}
