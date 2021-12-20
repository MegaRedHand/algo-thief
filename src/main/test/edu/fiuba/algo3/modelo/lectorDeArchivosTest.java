package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class lectorDeArchivosTest {

    @Test
    public void test01seLeeLaCiudadCorrectamente() throws IOException {
        LectorDeArchivos lector = new LectorDeArchivos();
        final List<Map<?,?> > ciudades = lector.leerJson("archivos/ciudades.json");

        System.out.println(ciudades.get(0));  //la primera ciudad
        System.out.println((ciudades.get(0)).get("Flag")); //de la primera ciudad , la bandera


        //para imprimir primer elemento de bandera
        ArrayList<String> bandera = (ArrayList<String>) (ciudades.get(0)).get("Flag");
        System.out.println(bandera.get(0));
    }
}
