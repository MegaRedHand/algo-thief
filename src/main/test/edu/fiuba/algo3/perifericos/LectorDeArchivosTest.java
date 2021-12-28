package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.CiudadBuilder;
import edu.fiuba.algo3.modelo.Comun;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.ObjetoRobado;
import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;

public class LectorDeArchivosTest {

    public Map<String,String> setup(){
        Map<String,String> rutas = new HashMap<String,String>();
        rutas.put("ciudades","archivos/ciudades.json");
        rutas.put("ladrones","archivos/ladrones.json");
        rutas.put("objetos","archivos/objetos.json");

        return rutas;
    }

//    @Test
//    public void test01seLeeLaCiudadCorrectamente() throws IOException {
//        LectorDeArchivos lector = new LectorDeArchivos();
//        List<CiudadBuilder> ciudades = lector.crearCiudadesBuilder("archivos/ciudades.json");
//        System.out.println(ciudades);
//    }
    /*
    @Test
    public void test02seLeeLosLadronesCorrectamente() throws IOException {
        Map<String,String> rutas = setup();
        LectorDeArchivos lector = new LectorDeArchivos(rutas);


        List<Ladron> ladrones = lector.obtenerLadrones();
        System.out.println(ladrones);
    }
    */

    @Test
    public void test03seLeenLosObjetosCorrectamente() throws IOException {
        Map<String,String> rutas = setup();

        System.out.println(rutas);


        LectorDeArchivos lector = new LectorDeArchivos(rutas);


        lector.obtenerObjetosRobados();
        List<Comun> comunes = lector.obtenerObjetosComunes();
        System.out.println(comunes);




    }



}
