package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.DescripcionSospechoso;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Rasgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectorLadrones {


    private final LectorJson lector;

    public LectorLadrones(String rutaArchivo) {

        this.lector = new LectorJson(rutaArchivo);
    }

    public List<Ladron> obtenerLadrones() {
        List<Map<String,?>> ladronesLista = this.lector.leerJson();

        Map<String,?> ladronMap;
        List<Ladron> ladrones = new ArrayList<>();

        for (Map<String, ?> stringMap : ladronesLista) {
            ladronMap = stringMap;
            Rasgo sexo = new Rasgo("sexo", ladronMap.get("sexo").toString());
            Rasgo hobby = new Rasgo("hobby", ladronMap.get("hobby").toString());
            Rasgo ocupacion = new Rasgo("ocupacion", ladronMap.get("ocupacion").toString());
            Rasgo cabello = new Rasgo("cabello", ladronMap.get("colorDelPelo").toString());
            Rasgo senia = new Rasgo("seña", ladronMap.get("señasParticulares").toString());
            Rasgo vehiculo = new Rasgo("vehiculo", ladronMap.get("coche").toString());

            DescripcionSospechoso descripcion = new DescripcionSospechoso(sexo, hobby, cabello, senia, vehiculo, ocupacion);
            Ladron ladron = new Ladron(ladronMap.get("nombre").toString(), descripcion);

            ladrones.add(ladron);
        }
        return ladrones;
    }
}
