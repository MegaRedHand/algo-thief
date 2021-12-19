package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EscenarioBuilder implements Builder {

    private ObjetoRobado objeto;
    private Ladron ladron;
    private final List<CiudadBuilder> buildersDeCiudades = new ArrayList<>();
    private Cronometro cronometro;

    public EscenarioBuilder conObjetoRobado(ObjetoRobado objeto) {
        this.objeto = objeto;
        return this;
    }

    public EscenarioBuilder conLadron(String nombre, DescripcionSospechoso descripcion) {
        ladron = new Ladron(nombre, descripcion, objeto);
        return this;
    }

    public CiudadBuilder conCiudad(String nombre) {
        CiudadBuilder builder = new CiudadBuilder(nombre);
        buildersDeCiudades.add(builder);
        return builder;
    }

    public Escenario construirCon(ContadorDeDificultad contador) {
        List<Ciudad> rutaDeEscape = buildersDeCiudades.stream().map(CiudadBuilder::construir)
                .collect(Collectors.toList());
        Detective detective = new Detective(cronometro, rutaDeEscape.get(0), contador);

        return new Escenario(detective, ladron, rutaDeEscape);
    }

    public EscenarioBuilder conCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
        return this;
    }
}
