package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Ciudad {

    private final String nombre;
    private final List<Edificio> edificios;
    private List<String> adyacentes;
    //private final DatosDeCiudad datos;
    //private final HashMap<String, List<String>> datos;

    public Ciudad(String nombre, Edificio... edificios) {
        this.nombre = nombre;
        this.edificios = new ArrayList<>(List.of(edificios));

    }

    public Ciudad(String nombre, List<Edificio> edificios) {
        this.nombre = nombre;
        this.edificios = new ArrayList<>(edificios);
    }

    public Ciudad(String nombre, List<Edificio> edificios, List<String> adyacentes) {
        this.nombre = nombre;
        this.edificios = new ArrayList<>(edificios);
        this.adyacentes = adyacentes;
    }

    public Edificio obtenerEdificio(String nombreEdificio) {
        return edificios.stream().filter(e -> e.es(nombreEdificio)).findAny().orElseThrow();
    }

    public boolean es(String nombreCiudad) {
        return nombre.equals(nombreCiudad);
    }

    public List<String> edificiosVisitables() {
        return edificios.stream().map(Edificio::toString).collect(Collectors.toList());
    }

    public List<String> ciudadesVisitables() {
        return new ArrayList<>(adyacentes);
    }

    /*
    public void agregarDatosDeCiudad(DatosDeCiudad datosDeCiudad){

        this.datos = datosDeCiudad;
    }



    public void agregarDatosDeCiudad(HashMap<String, List<String>> datosDeCiudad){

        this.datos = datosDeCiudad;
    }

     */
}
