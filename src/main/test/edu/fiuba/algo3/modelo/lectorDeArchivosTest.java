package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class lectorDeArchivosTest {

    @Test
    public void test01seLeeLaCiudadCorrectamente() throws IOException {
        LectorDeArchivos lector = new LectorDeArchivos();
        String ciudad = lector.leerJson("archivos/ciudades.json");
        System.out.println(ciudad);

    }
}
