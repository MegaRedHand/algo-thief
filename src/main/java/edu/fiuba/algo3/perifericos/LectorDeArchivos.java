package edu.fiuba.algo3.perifericos;


import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class LectorDeArchivos implements FuenteDeDatos {


    // --------------------ESTO HAY QUE SACARLO------------------------------------------------
    static final String RUTA_CIUDADES = "archivos/ciudades.json";
    static final String RUTA_LADRONES = "archivos/ladrones.json";
    static final String RUTA_OBJETOS = "archivos/objetos.json";
    // ----------------------------------------------------------------------------------------

    private Computadora computadora;
    private final LectorJson lectorDeJson;
    private final String rutaCiudades;
    private final String rutaLadrones;
    private final String rutaObjetos;
    private final List<Comun> objetosComunes = new ArrayList<>();
    private final List<Valioso> objetosValiosos = new ArrayList<>();
    private final List<MuyValioso> objetosMuyValiosos = new ArrayList<>();


    public LectorDeArchivos(Map<String, String> rutas, LectorJson lectorDeJson){
        this.rutaCiudades = rutas.get("ciudades");
        this.rutaLadrones = rutas.get("ladrones");
        this.rutaObjetos = rutas.get("objetos");
        this.lectorDeJson = lectorDeJson;
    }

    @Override
    public Pista obtenerPista(String dificultad, String tipoEdificio) {
        return new Pista("");
    }

    @Override
    public Computadora getComputadora() {
        if (computadora == null) {
            computadora = new Computadora(obtenerLadrones());
        }
        return computadora;
    }

    @Override
    public List<Comun> obtenerObjetosComunes() {
        if (objetosComunes.size() == 0) {
            cargarObjetosRobados();
        }
        return objetosComunes;
    }

    @Override
    public List<Valioso> obtenerObjetosValiosos() {
        if (objetosValiosos.size() == 0) {
            cargarObjetosRobados();
        }
        return objetosValiosos;
    }

    @Override
    public List<MuyValioso> obtenerObjetosMuyValiosos() {
        if (objetosMuyValiosos.size() == 0) {
            cargarObjetosRobados();
        }
        return objetosMuyValiosos;
    }

    @Override
    public List<CiudadBuilder> crearCiudadBuilders(){
        List<Map<String,?> > datosCiudades = this.lectorDeJson.leerJson(this.rutaCiudades);
        List<CiudadBuilder> listaCiudadesBuilder = new ArrayList<>();

        for (Map<String,?> ciudadMap : datosCiudades) {
            CiudadBuilder ciudad = new CiudadBuilder(ciudadMap);
            listaCiudadesBuilder.add(ciudad);
        }
        return listaCiudadesBuilder;
    }


    private List<Ladron> obtenerLadrones() {
        List<Map<String,?> > ladronesLista = this.lectorDeJson.leerJson(this.rutaLadrones);

        Map<String,?> ladronMap;
        List<Ladron> ladrones = new ArrayList<>();

        for (Map<String, ?> stringMap : ladronesLista) {
            ladronMap = stringMap;
            Rasgo sexo = new Rasgo("sexo", ladronMap.get("sexo").toString());
            Rasgo hobby = new Rasgo("hobby", ladronMap.get("hobby").toString());
            Rasgo cabello = new Rasgo("cabello", ladronMap.get("colorDelPelo").toString());
            Rasgo senia = new Rasgo("seña", ladronMap.get("señasParticulares").toString());
            Rasgo vehiculo = new Rasgo("vehiculo", ladronMap.get("coche").toString());

            DescripcionSospechoso descripcion = new DescripcionSospechoso(sexo, hobby, cabello, senia, vehiculo);
            Ladron ladron = new Ladron(ladronMap.get("nombre").toString(), descripcion);

            ladrones.add(ladron);
        }
        return ladrones;
    }



    private void cargarObjetosRobados() {
        List<Map<String,?> > objetosLista = lectorDeJson.leerJson(this.rutaObjetos);

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




