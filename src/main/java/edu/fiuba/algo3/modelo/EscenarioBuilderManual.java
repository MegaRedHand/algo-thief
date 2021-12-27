package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EscenarioBuilderManual implements EscenarioBuilder {

    private ObjetoRobado objeto;
    private Ladron ladron;
    private final List<CiudadBuilder> buildersDeCiudades = new ArrayList<>();
    private Cronometro cronometro;

    public EscenarioBuilderManual conCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
        return this;
    }

    public void conObjetoRobado(ObjetoRobado objeto) {
        this.objeto = objeto;
    }

    public void conLadron(String nombre, DescripcionSospechoso descripcion) {
        ladron = new Ladron(nombre, descripcion, objeto);
    }

    public void conCiudades(CiudadBuilder... ciudadBuilders) {
        buildersDeCiudades.addAll(List.of(ciudadBuilders));
    }

    public void conCiudades(List<CiudadBuilder> ciudadBuilders) {
        buildersDeCiudades.addAll(ciudadBuilders);
    }

    public Escenario construirCon(ContadorDeDificultad contador, FuenteDeDatos fuente) {
        List<Ciudad> rutaDeEscape = buildersDeCiudades.stream().map(b -> b.construirCon(contador.rango(), fuente))
                .collect(Collectors.toList());
        Detective detective = new Detective(cronometro, rutaDeEscape.get(0), contador);

        return new Escenario(detective, ladron, rutaDeEscape);
    }

    public void conLadron(Ladron ladron) {
        this.ladron = ladron;
    }

    public Escenario construirCon(ContadorDeDificultad contador, DescripcionSospechoso descripcion) {
        List<Ciudad> rutaDeEscape = buildersDeCiudades.stream().map(b -> b.construirCon(contador.rango(), descripcion))
                .collect(Collectors.toList());
        Detective detective = new Detective(cronometro, rutaDeEscape.get(0), contador);

        return new Escenario(detective, ladron, rutaDeEscape);
    }

    @Override
    public Cronometro obtenerCronometro() {
        return cronometro;
    }
}
