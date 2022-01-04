package edu.fiuba.algo3.perifericos;

import edu.fiuba.algo3.modelo.Comun;
import edu.fiuba.algo3.modelo.MuyValioso;
import edu.fiuba.algo3.modelo.Valioso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectorObjetos {
    private final LectorJson lector;
    private final List<Comun> objetosComunes = new ArrayList<>();
    private final List<Valioso> objetosValiosos = new ArrayList<>();
    private final List<MuyValioso> objetosMuyValiosos = new ArrayList<>();

    public LectorObjetos(String rutaArchivo) {

        this.lector = new LectorJson(rutaArchivo);
    }
    public List<Comun> obtenerObjetosComunes() {
        if (objetosComunes.size() == 0) {
            cargarObjetosRobados();
        }
        return objetosComunes;
    }


    public List<Valioso> obtenerObjetosValiosos() {
        if (objetosValiosos.size() == 0) {
            cargarObjetosRobados();
        }
        return objetosValiosos;
    }


    public List<MuyValioso> obtenerObjetosMuyValiosos() {
        if (objetosMuyValiosos.size() == 0) {
            cargarObjetosRobados();
        }
        return objetosMuyValiosos;
    }

    private void cargarObjetosRobados() {
        List<Map<String,?>> objetosLista = this.lector.leerJson();

        for (Map<String,?> objetoMap : objetosLista){

            if ((objetoMap.get("valor")).equals("Comun")) {
                Comun objetoComun = new Comun(objetoMap.get("tesoro").toString(), objetoMap.get("ciudad").toString());
                objetosComunes.add(objetoComun);
            } else if ((objetoMap.get("valor")).equals("Valioso")) {
                Valioso objetoValioso = new Valioso(objetoMap.get("tesoro").toString(), objetoMap.get("ciudad").toString());
                objetosValiosos.add(objetoValioso);
            } else {
                MuyValioso objetoMuyValioso = new MuyValioso(objetoMap.get("tesoro").toString(), objetoMap.get("ciudad").toString());
                objetosMuyValiosos.add(objetoMuyValioso);
            }
        }
    }
}
