package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.CiudadBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectorCiudades {
    private final LectorJson lector;

    public LectorCiudades(String rutaArchivo) {

        this.lector = new LectorJson(rutaArchivo);
    }

    public List<CiudadBuilder> obtenerCiudadesBuilder(){
        List<Map<String,?>> datosCiudades = this.lector.leerJson();
        List<CiudadBuilder> listaCiudadesBuilder = new ArrayList<>();

        for (Map<String,?> ciudadMap : datosCiudades) {
            CiudadBuilder ciudad = new CiudadBuilder(ciudadMap);
            listaCiudadesBuilder.add(ciudad);
        }
        return listaCiudadesBuilder;
    }
}
