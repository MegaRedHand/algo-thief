package edu.fiuba.algo3.modelo;

import java.util.Map;

public interface Rango {
    Rango actualizar(int cantidadDeArrestos);
    int tiempoDeViaje(int distanciaEnKms);
    Pista generarPistaCon(GeneradorDePistas generador, Map<String, ?> datosCiudad, DescripcionSospechoso descripcion);
}
