package edu.fiuba.algo3.modelo;

import java.util.Map;

public class EdificioBuilder {

    private final String nombreEdificio;
    private Pista pista;
    private String tipoEdificio;
    private DescripcionSospechoso descripcionLadron;
    private Map<String, ?> datosSiguienteCiudad;
    private GeneradorDePistas generador;

    public EdificioBuilder(String nombreEdificio, String tipoEdificio) {
        this.nombreEdificio = nombreEdificio;
        this.tipoEdificio = tipoEdificio;
    }

    public EdificioBuilder(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public void conPista(Pista pista) {
        this.pista = pista;
    }

    public Edificio construir() {
        return new Edificio(nombreEdificio, pista);
    }

    public Edificio construirCon(Rango rango, FuenteDeDatos fuente) {
        return new Edificio(nombreEdificio, fuente.obtenerPista(rango.dificultad(), tipoEdificio));
    }

    public void conPistaPara(DescripcionSospechoso descripcion, Map<String, ?> datosSiguienteCiudad) {
        this.descripcionLadron = descripcion;
        this.datosSiguienteCiudad = datosSiguienteCiudad;
    }

    public void conPistaGeneradaPor(GeneradorDePistas generadorDePistas) {
        this.generador = generadorDePistas;
    }

    public Edificio construirCon(Rango rango) {
        // TODO: podría ser algo como
        //  pista = rango.generadorDePistas().pistaMoneda(datosSiguienteCiudad).agregar(datosSospechoso).generar()
        if (datosSiguienteCiudad == null) {
            pista = new Pista("No hemos visto a ningún sospechoso por aquí.");
        } else {
            String vehiculo = descripcionLadron.getVehiculo();
            String moneda = datosSiguienteCiudad.get("Currency").toString();
            pista = new Pista(String.format("La moneda del país es %s. El ladrón se fue en un %s.", moneda, vehiculo));
        }
        return new Edificio(nombreEdificio, pista);
    }

    public Edificio construirCon(Rango rango, DescripcionSospechoso descripcion) {
        return new Edificio(nombreEdificio, rango.generarPistaCon(generador, datosSiguienteCiudad, descripcion));
    }

}
