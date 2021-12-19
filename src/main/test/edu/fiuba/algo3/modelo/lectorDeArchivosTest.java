package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class lectorDeArchivosTest {

    @Test
    public void test01seLeeLaCiudadCorrectamente() throws IOException {
        LectorDeArchivos lector = new LectorDeArchivos();
        lector.leerJson("archivos/ciudades.json");


    }
}
