package edu.fiuba.algo3.perifericos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.Computadora;
import edu.fiuba.algo3.modelo.DatosDeCiudad;
import edu.fiuba.algo3.modelo.FuenteDeDatos;
import edu.fiuba.algo3.modelo.Pista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class LectorDeArchivos implements FuenteDeDatos {

    static final String RUTA_CIUDADES = "archivos/ciudades.json";

    @Override
    public Pista obtenerPista(String dificultad, String tipoEdificio) {
        return new Pista("");
    }

    @Override
    public Computadora getComputadora() {
        return null;
    }


    public List<Map<?,?> >  leerJson(String rutaArchivo)throws IOException{
        List<Map<?,?> > ciudades = null;

        try {
            Reader archivo = Files.newBufferedReader(Paths.get(rutaArchivo));
            Gson gson = new Gson();

            final Type tipoListaCiudades = new TypeToken<List<Map<?,?> >>(){}.getType();
            ciudades = gson.fromJson(archivo, tipoListaCiudades);


        }catch (IOException e){
            e.printStackTrace();
        }

        return ciudades;

    }

}

