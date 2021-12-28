package edu.fiuba.algo3.modelo;


import java.util.*;
import java.util.stream.Collectors;

public class RandomBuilder implements EscenarioBuilder {
    Cronometro cronometro = new Cronometro(0);

    @Override
    public Escenario construirCon(ContadorDeDificultad contador, FuenteDeDatos fuente) {
        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        List<Ladron> ladrones = fuente.getComputadora().listaDeLadrones();
        Ladron ladron = ladrones.get(new Random().nextInt(ladrones.size()));
        builder.conLadron(ladron);

        ObjetoRobado objetoRobado = contador.obtenerObjetosRobados(fuente);
        builder.conCronometro(cronometro).conObjetoRobado(objetoRobado);

        List<CiudadBuilder> ciudadBuilders = generarListaDeCiudadBuilders(fuente, objetoRobado);

        List<CiudadBuilder> rutaDeEscape = new ArrayList<>(ciudadBuilders.subList(
                0, objetoRobado.largoDeLaRutaDeEscape()));
        List<CiudadBuilder> ciudadesNoVisitadas = new ArrayList<>(ciudadBuilders.subList(
                objetoRobado.largoDeLaRutaDeEscape(), ciudadBuilders.size()));

        agregarAdyacentesACiudades(ciudadesNoVisitadas, rutaDeEscape);

        ciudadBuilders.forEach(this::agregarEdificios);

        return builder.construirCon(contador, ladron.descripcion());
    }

    private List<CiudadBuilder> generarListaDeCiudadBuilders(FuenteDeDatos fuente, ObjetoRobado objetoRobado) {
        List<CiudadBuilder> ciudadBuilders = fuente.crearCiudadBuilders();
        CiudadBuilder ciudadInicial = ciudadBuilders.stream().filter(cb -> cb.lePertenece(objetoRobado)).findFirst().orElseThrow();
        ciudadBuilders.remove(ciudadInicial);
        Collections.shuffle(ciudadBuilders);
        ciudadBuilders.add(0, ciudadInicial);
        return ciudadBuilders;
    }

    private void agregarAdyacentesACiudades(List<CiudadBuilder> ciudadesNoVisitadas, List<CiudadBuilder> rutaDeEscape) {
        for (int i = 0; i < rutaDeEscape.size() - 1; i++) {
            List<CiudadBuilder> adyacentes = new ArrayList<>(ciudadesNoVisitadas.subList(0, 2));
            ciudadesNoVisitadas.removeAll(adyacentes);
            adyacentes.add(rutaDeEscape.get(i + 1));
            rutaDeEscape.get(i).conPasajesA(adyacentes);
            rutaDeEscape.get(i).conPistasPara(rutaDeEscape.get(i + 1));
        }
    }

    private void agregarEdificios(CiudadBuilder ciudadBuilder) {
        EdificioBuilder edificioBuilder = new EdificioBuilder("Banco");
        edificioBuilder.conPistaGeneradaPor(new GeneradorDePistasBanco());
        ciudadBuilder.conEdificios(edificioBuilder);
    }

    @Override
    public Cronometro obtenerCronometro() {
        return cronometro;
    }

}
