package edu.fiuba.algo3.perifericos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.*;

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
    static final String RUTA_LADRONES = "archivos/ladrones.json";

    private List<Map<String,?>> datosDeCiudades;
    private Computadora computadora;

    @Override
    public Pista obtenerPista(String dificultad, String tipoEdificio) {
        return new Pista("");
    }

    @Override
    public Computadora getComputadora() {
        if (computadora == null) {
            computadora = new Computadora(obtenerLadrones(RUTA_LADRONES));
        }
        return computadora;
    }



    private List<Map<String,?>>  leerJson(String rutaArchivo) {
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

    public List<Map<String,?> > obtenerCiudades(String rutaArchivo) {
        List<Map<String,?> > ciudades = leerJson(rutaArchivo);
        return ciudades;
    }

    @Override
    public List<Map<String, ?>> obtenerDatosDeCiudades() {
        if (datosDeCiudades == null) {
            datosDeCiudades = leerJson(RUTA_CIUDADES);
        }
        return datosDeCiudades;
    }

    public List<Ladron> obtenerLadrones(String rutaArchivo) {
        List<Map<String,?> > ladronesLista = leerJson(rutaArchivo);

        Map<String,?> ladronMap;
        List<Ladron> ladrones = new ArrayList<>();

        for (int i= 0; i < ladronesLista.size();i++){
            ladronMap = ladronesLista.get(i);

            Rasgo sexo = new Rasgo("sexo",(String) ladronMap.get("Sex"));
            Rasgo hobby = new Rasgo("hobby",(String) ladronMap.get("Hobby"));
            Rasgo cabello = new Rasgo("cabello",(String) ladronMap.get("Hair"));
            Rasgo seña = new Rasgo("seña",(String) ladronMap.get("Feature"));
            Rasgo vehiculo = new Rasgo("vehiculo",(String) ladronMap.get("Auto"));

            DescripcionSospechoso descripcion = new DescripcionSospechoso(sexo,hobby,cabello,seña,vehiculo);
            Ladron ladron = new Ladron((String) ladronMap.get("Name"), descripcion);

            ladrones.add(ladron);
        }
        return ladrones;
    }


}


/*
    //  lector viejo
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

     */

