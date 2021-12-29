package edu.fiuba.algo3.perifericos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
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
        List<Map<String,?>> datos = null;
        try {
            Reader archivo = Files.newBufferedReader(Paths.get(rutaArchivo));
            Gson gson = new Gson();

            final Type tipoListaDatos = new TypeToken<List<Map<?,?> >>(){}.getType();
            datos = gson.fromJson(archivo, tipoListaDatos);

        }catch (IOException e){
            e.printStackTrace();
        }
        return datos;
    }

}
