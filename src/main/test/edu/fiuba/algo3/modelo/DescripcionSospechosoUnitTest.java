package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DescripcionSospechosoUnitTest {

    @Test
    public void test01DescripcionDePocosRasgosCoincideConDescripcionMasDetallada() {

        DescripcionSospechoso dePocosRasgos = new DescripcionSospechoso().conHobby("Tenis").conSexo("Femenino");
        DescripcionSospechoso masDetallada = new DescripcionSospechoso("Nombre", "Femenino", "Tenis", "Castaño", "Anillo", "Descapotable");

        assertTrue(dePocosRasgos.coincideCon(masDetallada));
    }

    @Test
    public void test02DescripcionDetalladaNoCoincideConDescripcionDePocosRasgos() {

        DescripcionSospechoso masDetallada = new DescripcionSospechoso("Nombre", "Femenino", "Tenis", "Castaño", "Anillo", "Descapotable");
        DescripcionSospechoso dePocosRasgos = new DescripcionSospechoso().conHobby("Tenis").conSexo("Femenino");

        assertFalse(masDetallada.coincideCon(dePocosRasgos));
    }

    @Test
    public void test03AlAgregarDosDescripcionesSeComportaIgualQueUnaDescripcionCreadaConLosMismosRasgos() {

        DescripcionSospechoso conSexoYHobby = new DescripcionSospechoso().conHobby("Tenis").conSexo("Femenino");

        DescripcionSospechoso conSexo = new DescripcionSospechoso().conSexo("Femenino");
        DescripcionSospechoso conHobby = new DescripcionSospechoso().conHobby("Tenis");

        DescripcionSospechoso agregada = conSexo.agregar(conHobby);

        assertTrue(agregada.coincideCon(conSexoYHobby));
    }

}
