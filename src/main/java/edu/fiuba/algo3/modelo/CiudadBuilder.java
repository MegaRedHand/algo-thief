package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CiudadBuilder {

    private String nombreCiudad;
    private final List<Edificio> edificiosDeLaCiudad = new ArrayList<>();
    private final List<EdificioBuilder> edificioBuilders = new ArrayList<>();
    private DatosDeCiudad datos;
    private Map<String, ?> datosSiguienteCiudad;
    private Map<String, ?> datosCiudad;
    private final List<String> adyacentes = new ArrayList<>();


    public CiudadBuilder(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public CiudadBuilder(Map<String, ?> datosCiudad) {
        this.nombreCiudad = datosCiudad.get("City").toString();
        this.datosCiudad = datosCiudad;
    }

    public CiudadBuilder conEdificios(EdificioBuilder... edificioBuilders) {
        this.edificioBuilders.addAll(List.of(edificioBuilders));
        return this;
    }

    public Ciudad construirCon(Rango rango, FuenteDeDatos fuente) {
        List<Edificio> edificiosDeLaCiudad = edificioBuilders.stream().map(b -> b.construirCon(rango, fuente))
                .collect(Collectors.toList());
        return new Ciudad(nombreCiudad, edificiosDeLaCiudad);
    }

    public Ciudad construir() {
        List<Edificio> edificiosDeLaCiudad = edificioBuilders.stream().map(EdificioBuilder::construir)
                .collect(Collectors.toList());
        return new Ciudad(nombreCiudad, edificiosDeLaCiudad);
    }

    public void conPasajesA(List<CiudadBuilder> adyacentes) {
        List<String> nombresAdyacentes = adyacentes.stream().map(cb -> cb.datosCiudad.get("City").toString()).collect(Collectors.toList());
        this.adyacentes.addAll(nombresAdyacentes);
    }

    public void conPistasPara(Map<String, ?> datosSiguienteCiudad) {
        this.datosSiguienteCiudad = datosSiguienteCiudad;
    }

    public Ciudad construirCon(Rango rango, DescripcionSospechoso descripcion) {
        edificioBuilders.forEach(eb -> eb.conPistaPara(descripcion, datosSiguienteCiudad));
        List<Edificio> edificiosDeLaCiudad = edificioBuilders.stream().map(eb -> eb.construirCon(rango))
                .collect(Collectors.toList());

        return new Ciudad(nombreCiudad, edificiosDeLaCiudad, adyacentes);
    }

//    public Ciudad construirCon(Rango rango, DatosDeCiudad datosDeLaSiguienteCiudad, Ladron ladron) {
//        edificiosDeLaCiudad.forEach(e -> e.agregarPista(rango, datosDeLaSiguienteCiudad, ladron));
//        return new Ciudad(nombreCiudad, edificiosDeLaCiudad);
//    }

}
