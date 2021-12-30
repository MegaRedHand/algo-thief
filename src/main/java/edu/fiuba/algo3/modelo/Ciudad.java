package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ciudad {

    private final String nombre;
    private final List<Edificio> edificios = new ArrayList<>();
    private final List<String> nombresAdyacentes = new ArrayList<>();
    private Coordenadas coordenadas;

    public Ciudad(String nombre, Edificio... edificios) {
        // TODO: eliminar
        this.nombre = nombre;
        this.edificios.addAll(List.of(edificios));
    }

    public Ciudad(String nombre, List<Edificio> edificios, List<String> nombresAdyacentes, Coordenadas coordenadas) {
        this.nombre = nombre;
        this.edificios.addAll(edificios);
        this.nombresAdyacentes.addAll(nombresAdyacentes);
        this.coordenadas = coordenadas;
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
        return new ArrayList<>(nombresAdyacentes);
    }

    public int distanciaA(Ciudad ciudadDestino) {
        return Double.valueOf(coordenadas.distanciaA(ciudadDestino.coordenadas)).intValue();
    }
}
