package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EscenarioBuilder {
    private final Rango rango;
    private Comun objeto;
    private Ladron ladron;
    private final List<CiudadBuilder> buildersDeCiudades = new ArrayList<>();
    private Cronometro cronometro;

    public EscenarioBuilder(int numeroDeArrestos) {

        rango = new Novato(); // TODO: lógica de cambio de rangos (CoR?)
    }

    public EscenarioBuilder conObjetoRobado(String nombre) {
        objeto = new Comun(nombre); // TODO: lógica de selección de rareza
        return this;
    }

    public EscenarioBuilder conLadron(String sexo) { // TODO: parámetros primitivos
        ladron = new Ladron(objeto, sexo);
        return this;
    }

    public CiudadBuilder conCiudad(String nombre) {
        CiudadBuilder builder = new CiudadBuilder(nombre);
        buildersDeCiudades.add(builder);
        return builder;
    }

    public Escenario construir() {
        List<Ciudad> rutaDeEscape = buildersDeCiudades.stream().map(CiudadBuilder::construir)
                .collect(Collectors.toList());
        Detective detective = new Detective(cronometro, rutaDeEscape.get(0), rango);

        return new Escenario(detective, ladron, rutaDeEscape);
    }

    public EscenarioBuilder conCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
        return this;
    }
}
