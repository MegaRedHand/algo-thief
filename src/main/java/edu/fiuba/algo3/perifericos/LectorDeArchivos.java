package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.Computadora;
import edu.fiuba.algo3.modelo.DatosDeCiudad;
import edu.fiuba.algo3.modelo.FuenteDeDatos;
import edu.fiuba.algo3.modelo.Pista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;


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


    public void leerJson(String rutaArchivo)throws IOException{
        String jsonLeido = "";

        try {

            BufferedReader buffer = new BufferedReader(new FileReader(rutaArchivo));

            String linea;


            while ((linea = buffer.readLine()) != null) {
                jsonLeido += linea ;

            }

            buffer.close();



        } catch (IOException ex){
            System.out.println("Error lectura");
        }

        System.out.println(jsonLeido);


    }

}
