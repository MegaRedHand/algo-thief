package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.CiudadBuilder;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.ObjetoRobado;
import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectorDeArchivosTest {

    @Test
    public void test01seLeeLaCiudadCorrectamente() throws IOException {
        LectorDeArchivos lector = new LectorDeArchivos();
        List<CiudadBuilder> ciudades = lector.crearCiudadesBuilder("archivos/ciudades.json");
        System.out.println(ciudades);
    }
    @Test
    public void test02seLeeLosLadronesCorrectamente() throws IOException {
        LectorDeArchivos lector = new LectorDeArchivos();


        List<Ladron> ladrones = lector.obtenerLadrones("archivos/ladrones.json");
        System.out.println(ladrones);
    }

    @Test
    public void test03seLeenLosObjetosCorrectamente() throws IOException {
        LectorDeArchivos lector = new LectorDeArchivos();


        List<ObjetoRobado> objetos = lector.obtenerObjetosRobados("archivos/objetos.json");
        System.out.println(objetos);
    }

}
