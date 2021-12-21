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

    @Override
    public Pista obtenerPista(String dificultad, String tipoEdificio) {
        return new Pista("");
    }

    @Override
    public Computadora getComputadora() {
        return null;
    }



    private List<Map<?,?>>  leerJson(String rutaArchivo)throws IOException{
        List<Map<?,?>> datos = null;

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

    public List<Map<?,?> > obtenerCiudades(String rutaArchivo) throws IOException {

        List<Map<?,?> > ciudades = leerJson(rutaArchivo);
        return ciudades;
    }


    public List<Ladron> obtenerLadrones(String rutaArchivo) throws IOException {
        List<Map<?,?> > ladronesLista = leerJson(rutaArchivo);

        Map<?,?> ladronMap;
        List<Ladron> ladrones = new ArrayList<Ladron>();

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

