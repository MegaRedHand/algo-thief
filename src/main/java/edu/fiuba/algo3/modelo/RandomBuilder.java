package edu.fiuba.algo3.modelo;


import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class RandomBuilder implements EscenarioBuilder {
    Cronometro cronometro = new Cronometro(0);

    @Override
    public Escenario construirCon(ContadorDeDificultad contador, FuenteDeDatos fuente) {
        EscenarioBuilderManual builder = new EscenarioBuilderManual();

        Ladron ladron = obtenerLadron(fuente);
        builder.conLadron(ladron);

        ObjetoRobado objetoRobado;
        List<CiudadBuilder> ciudadBuilders;

        while (true) {
            try {
                objetoRobado = obtenerObjetoRobado(contador, fuente);

                ciudadBuilders = generarListaDeCiudadBuilders(fuente, objetoRobado);
            } catch (NoSuchElementException e) {
                continue;
            }
            break;
        }
        builder.conCronometro(cronometro).conObjetoRobado(objetoRobado);
        builder.conCiudades(ciudadBuilders.toArray(new CiudadBuilder[0]));

        List<CiudadBuilder> rutaDeEscape = new ArrayList<>(ciudadBuilders.subList(
                0, objetoRobado.largoDeLaRutaDeEscape()));
        List<CiudadBuilder> ciudadesNoVisitadas = new ArrayList<>(ciudadBuilders.subList(
                objetoRobado.largoDeLaRutaDeEscape(), ciudadBuilders.size()));

        agregarAdyacentesACiudades(ciudadesNoVisitadas, rutaDeEscape);

        ciudadBuilders.forEach(this::agregarEdificios);
        rutaDeEscape.get(rutaDeEscape.size() - 1).conLadron(ladron);

        return builder.construirCon(contador, fuente);
    }

    private Ladron obtenerLadron(FuenteDeDatos fuente) {
        List<Ladron> ladrones = fuente.getComputadora().listaDeLadrones();
        return ladrones.get(new Random().nextInt(ladrones.size()));
    }

    private ObjetoRobado obtenerObjetoRobado(ContadorDeDificultad contador, FuenteDeDatos fuente) {
        List<ObjetoRobado> objetosRobados = contador.obtenerObjetosRobados(fuente);
        return objetosRobados.get(new Random().nextInt(objetosRobados.size()));
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
            rutaDeEscape.get(i).conPasajesA(adyacentes);
            rutaDeEscape.get(i).conPistasPara(rutaDeEscape.get(i + 1));
        }
    }

    private void agregarEdificios(CiudadBuilder ciudadBuilder) {
        List<Callable<EdificioBuilder>> constructores = new ArrayList<>(List.of(
                BancoBuilder::new,
                BibliotecaBuilder::new,
                PuertoBuilder::new,
                AeropuertoBuilder::new
        ));
        Collections.shuffle(constructores);

        for (int i = 0; i < 3; i++) {
            try {
                ciudadBuilder.conEdificios(constructores.get(i).call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Cronometro obtenerCronometro() {
        return cronometro;
    }

}
