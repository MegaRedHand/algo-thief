package edu.fiuba.algo3.perifericos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class LectorJson {

    private final String rutaArchivo;

    public LectorJson(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Map<String,?>> leerJson() {
        Reader archivo = new InputStreamReader(getClass().getResourceAsStream(rutaArchivo));
        Gson gson = new Gson();

        final Type tipoListaDatos = new TypeToken<List<Map<?,?> >>(){}.getType();

        return gson.fromJson(archivo, tipoListaDatos);
    }

}
