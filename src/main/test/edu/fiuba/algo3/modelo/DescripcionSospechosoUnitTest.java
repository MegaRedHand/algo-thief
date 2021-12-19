package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DescripcionSospechosoUnitTest {

    @Test
    public void test01DescripcionDePocosRasgosCoincideConDescripcionMasDetallada() {

        DescripcionSospechoso dePocosRasgos = new DescripcionSospechoso(
                new Rasgo("Hobby", "Tenis"),
                new Rasgo("Sexo", "Femenino"));

        DescripcionSospechoso masDetallada = new DescripcionSospechoso(
                new Rasgo("Sexo", "Femenino"),
                new Rasgo("Hobby", "Tenis"),
                new Rasgo("Cabello", "Castaño"),
                new Rasgo("Seña", "Anillo"),
                new Rasgo("Vehículo", "Descapotable"));

        assertTrue(dePocosRasgos.coincideCon(masDetallada));
    }

    @Test
    public void test02DescripcionDetalladaNoCoincideConDescripcionDePocosRasgos() {

        DescripcionSospechoso masDetallada = new DescripcionSospechoso(
                new Rasgo("Sexo", "Femenino"),
                new Rasgo("Hobby", "Tenis"),
                new Rasgo("Cabello", "Castaño"),
                new Rasgo("Seña", "Anillo"),
                new Rasgo("Vehículo", "Descapotable"));

        DescripcionSospechoso dePocosRasgos = new DescripcionSospechoso(
                new Rasgo("Hobby", "Tenis"),
                new Rasgo("Sexo", "Femenino"));

        assertFalse(masDetallada.coincideCon(dePocosRasgos));
    }

    @Test
    public void test03AlAgregarDosDescripcionesSeComportaIgualQueUnaDescripcionCreadaConLosMismosRasgos() {

        DescripcionSospechoso conSexoYHobby = new DescripcionSospechoso(
                new Rasgo("Hobby", "Tenis"),
                new Rasgo("Sexo", "Femenino"));

        DescripcionSospechoso conSexo = new DescripcionSospechoso(new Rasgo("Sexo", "Femenino"));
        DescripcionSospechoso conHobby = new DescripcionSospechoso(new Rasgo("Hobby", "Tenis"));

        DescripcionSospechoso agregada = new DescripcionSospechoso();
        agregada.agregar(conSexo);
        agregada.agregar(conHobby);

        assertTrue(agregada.coincideCon(conSexoYHobby));
    }

}
