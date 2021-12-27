package edu.fiuba.algo3.modelo;


import java.util.*;
import java.util.stream.Collectors;

public class RandomBuilder implements EscenarioBuilder {
    Cronometro cronometro = new Cronometro(0);

    @Override
    public Escenario construirCon(ContadorDeDificultad contador, FuenteDeDatos fuente) {
        EscenarioBuilderManual builder = new EscenarioBuilderManual();
        ObjetoRobado objetoRobado = contador.rango().crearObjetoRobado(fuente);

        builder.conCronometro(cronometro).conObjetoRobado(objetoRobado);

        List<Ladron> ladrones = fuente.getComputadora().listaDeLadrones();
        Ladron ladron = ladrones.get(new Random().nextInt(ladrones.size()));

        builder.conLadron(ladron);

        List<Map<String, ?>> datosCiudades = fuente.obtenerDatosDeCiudades();
        Collections.shuffle(datosCiudades);
        List<CiudadBuilder> ciudadesNoVisitadas = datosCiudades.stream().map(CiudadBuilder::new)
                .collect(Collectors.toList());

        builder.conCiudades(ciudadesNoVisitadas);
        ciudadesNoVisitadas.forEach(this::agregarEdificios);

        List<Map<String, ?>> datosRutaDeEscape = new ArrayList<>(datosCiudades.subList(0, objetoRobado.largoDeLaRutaDeEscape()));
        List<CiudadBuilder> rutaDeEscape = new ArrayList<>(ciudadesNoVisitadas.subList(0, objetoRobado.largoDeLaRutaDeEscape()));
        ciudadesNoVisitadas.removeAll(rutaDeEscape);

        agregarAdyacentesACiudades(ciudadesNoVisitadas, datosRutaDeEscape, rutaDeEscape);

        return builder.construirCon(contador, ladron.descripcion());
    }

    private void agregarAdyacentesACiudades(List<CiudadBuilder> ciudadesNoVisitadas, List<Map<String, ?>> datosRutaDeEscape, List<CiudadBuilder> rutaDeEscape) {
        for (int i = 0; i < rutaDeEscape.size() - 1; i++) {
            List<CiudadBuilder> adyacentes = new ArrayList<>(ciudadesNoVisitadas.subList(0, 2));
            ciudadesNoVisitadas.removeAll(adyacentes);
            adyacentes.add(rutaDeEscape.get(i + 1));
            rutaDeEscape.get(i).conPasajesA(adyacentes);
            rutaDeEscape.get(i).conPistasPara(datosRutaDeEscape.get(i + 1));
        }
    }

    private void agregarEdificios(CiudadBuilder ciudadBuilder) {
        ciudadBuilder.conEdificios(new EdificioBuilder("Banco"));
    }

    @Override
    public Cronometro obtenerCronometro() {
        return cronometro;
    }
}
