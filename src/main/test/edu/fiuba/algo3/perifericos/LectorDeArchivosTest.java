package edu.fiuba.algo3.perifericos;

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
        final List<Map<String, ?>> ciudades = lector.obtenerCiudades(LectorDeArchivos.RUTA_CIUDADES);

        System.out.println(ciudades.get(0));  //la primera ciudad
        System.out.println((ciudades.get(0)).get("colorBandera")); //de la primera ciudad , la bandera

        //para imprimir primer elemento de bandera
        ArrayList<String> bandera = (ArrayList<String>) (ciudades.get(0)).get("colorBandera");
        System.out.println(bandera.get(0));
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
