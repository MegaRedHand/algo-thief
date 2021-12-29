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

    public void conLadron(Ladron ladron) {
        this.ladron = ladron;
    }

    public void conCiudades(CiudadBuilder... ciudadBuilders) {
        buildersDeCiudades.addAll(List.of(ciudadBuilders));
    }

    public Escenario construirCon(ContadorDeDificultad contador, FuenteDeDatos fuente) {
        List<Ciudad> ciudades = buildersDeCiudades.stream().map(b -> b.construirCon(contador.rango(), ladron.descripcion()))
                .collect(Collectors.toList());
        Detective detective = new Detective(cronometro, ciudades.get(0), contador);

        return new Escenario(detective, ladron, ciudades);
    }

    @Override
    public Cronometro obtenerCronometro() {
        return cronometro;
    }
}
