package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CiudadBuilder {

    private final String nombreCiudad;
    private final List<EdificioBuilder> edificioBuilders = new ArrayList<>();
    private Map<String, ?> datosSiguienteCiudad;
    private final Map<String, ?> datosCiudad;
    private final List<String> adyacentes = new ArrayList<>();

    public CiudadBuilder(Map<String, ?> datosCiudad) {
        this.nombreCiudad = datosCiudad.get("ciudad").toString();
        this.datosCiudad = datosCiudad;
    }

    public boolean lePertenece(ObjetoRobado objetoRobado) {
        return objetoRobado.tieneOrigen(nombreCiudad);
    }

    public CiudadBuilder conEdificios(EdificioBuilder... edificioBuilders) {
        Arrays.stream(edificioBuilders).forEach(eb -> eb.deCiudad(this.nombreCiudad));
        this.edificioBuilders.addAll(List.of(edificioBuilders));
        return this;
    }

    public void conPasajesA(List<CiudadBuilder> adyacentes) {
        List<String> nombresAdyacentes = adyacentes.stream().map(cb -> cb.datosCiudad.get("ciudad").toString()).collect(Collectors.toList());
        this.adyacentes.addAll(nombresAdyacentes);
    }

    public CiudadBuilder conPistasPara(CiudadBuilder builderSiguienteCiudad) {
        this.datosSiguienteCiudad = builderSiguienteCiudad.datosCiudad;
        return this;
    }

    public Ciudad construirCon(Rango rango, DescripcionSospechoso descripcion) {
        List<Edificio> edificiosDeLaCiudad = edificioBuilders.stream()
                .map(eb -> eb.construirCon(rango, datosSiguienteCiudad, descripcion)).collect(Collectors.toList());

        Coordenadas coordenadas = new Coordenadas(
                Double.parseDouble(datosCiudad.get("latitud").toString()),
                Double.parseDouble(datosCiudad.get("longitud").toString())
        );
        return new Ciudad(nombreCiudad, edificiosDeLaCiudad, adyacentes, coordenadas);
    }

}
