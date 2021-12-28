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

    private List<Map<String,?>> datosDeCiudades;
    private List<ObjetoRobado> objetosRobados;
    private Computadora computadora;
    private LectorJson lectorDeJson = new LectorJson();
    private String rutaCiudades;
    private String rutaLadrones;
    private String rutaObjetos;
    private List<Comun> objetosComunes;
    private List<Valioso> objetosValiosos;
    private List<MuyValioso> objetosMuyValiosos;


    public LectorDeArchivos(Map<String,String> rutas){
        this.rutaCiudades = rutas.get("ciudades");
        this.rutaLadrones = rutas.get("ladrones");
        this.rutaObjetos = rutas.get("objetos");
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
    public Comun obtenerObjetosComunes() {
        return null;
    }

    @Override
    public Valioso obtenerObjetosValiosos() {
        return null;
    }

    @Override
    public MuyValioso obtenerObjetosMuyValiosos() {
        return null;
    }

    @Override
    public List<CiudadBuilder> crearCiudadBuilders(){
        List<Map<String,?> > datosCiudades = this.lectorDeJson.leerJson(this.rutaCiudades);
        List<CiudadBuilder> listaCiudadesBuilder = new ArrayList<>();

        for (Map<String,?> ciudadMap : datosCiudades){

            CiudadBuilder ciudad = new CiudadBuilder(ciudadMap);
            listaCiudadesBuilder.add(ciudad);
        }
        return listaCiudadesBuilder;
    }


    private List<Ladron> obtenerLadrones() {
        List<Map<String,?> > ladronesLista = this.lectorDeJson.leerJson(this.rutaLadrones);

        Map<String,?> ladronMap;
        List<Ladron> ladrones = new ArrayList<>();

        for (int i= 0; i < ladronesLista.size();i++){
            ladronMap = ladronesLista.get(i);
            Rasgo sexo = new Rasgo("sexo",(String) ladronMap.get("sexo"));
            Rasgo hobby = new Rasgo("hobby",(String) ladronMap.get("hobby"));
            Rasgo cabello = new Rasgo("cabello",(String) ladronMap.get("colorDelPelo"));
            Rasgo seña = new Rasgo("seña",(String) ladronMap.get("señasParticulares"));
            Rasgo vehiculo = new Rasgo("vehiculo",(String) ladronMap.get("coche"));

            DescripcionSospechoso descripcion = new DescripcionSospechoso(sexo,hobby,cabello,seña,vehiculo);
            Ladron ladron = new Ladron((String) ladronMap.get("nombre"), descripcion);

            ladrones.add(ladron);
        }
        return ladrones;
    }



    public List<ObjetoRobado> obtenerObjetosRobados(String rutaArchivo) {
        List<Map<String,?> > objetosLista = lectorDeJson.leerJson(rutaArchivo);

        Map<String,?> objetosMap;
        List<ObjetoRobado> objetos = new ArrayList<>();

//        for (int i= 0; i < objetosLista.size();i++){
//            objetosMap = objetosLista.get(i);
//            ObjetoRobado objeto;
//
//            if((objetosMap.get("valor")).equals("Comun")){
//                objeto = new Comun((String) objetosMap.get("nombre"));
//            }else if((objetosMap.get("valor")).equals("Valioso")){
//                objeto = new Valioso((String) objetosMap.get("nombre"));
//            }else {
//                objeto = new MuyValioso((String) objetosMap.get("nombre"));
//            }
//
//            objetos.add(objeto);
//        }
        return objetos;

    }


}




