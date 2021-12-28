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

    @Override
    public Pista obtenerPista(String dificultad, String tipoEdificio) {
        return new Pista("");
    }

    @Override
    public Computadora getComputadora() {
        if (computadora == null) {
            computadora = new Computadora(obtenerLadrones(RUTA_LADRONES));
        }
        return computadora;
    }


    /*  en lectorJson
    private List<Map<String,?>>  leerJson(String rutaArchivo) {
        List<Map<String,?>> datos = null;
        try {
            Reader archivo = Files.newBufferedReader(Paths.get(rutaArchivo));
            Gson gson = new Gson();

            final Type tipoListaDatos = new TypeToken<List<Map<?,?> >>(){}.getType();
            datos = gson.fromJson(archivo, tipoListaDatos);

        }catch (IOException e){
            e.printStackTrace();
        }
        return datos;
    }
    
     */


    @Override
    public List<CiudadBuilder> crearCiudadesBuilder(String rutaArchivo){
        List<Map<String,?> > datosCiudades = lectorDeJson.leerJson(rutaArchivo);
        List<CiudadBuilder> listaCiudadesBuilder = new ArrayList<>();

        for (Map<String,?> ciudadMap : datosCiudades){

            CiudadBuilder ciudad = new CiudadBuilder(ciudadMap);
            listaCiudadesBuilder.add(ciudad);
        }
        return listaCiudadesBuilder;
    }
    
    /*
    public List<Map<String,?> > obtenerCiudades(String rutaArchivo) {
        List<Map<String,?> > ciudades = lectorDeJson.leerJson(rutaArchivo);
        return ciudades;
    }

    @Override
    public List<Map<String, ?>> obtenerDatosDeCiudades() {
        if (datosDeCiudades == null) {
            datosDeCiudades = obtenerCiudades(RUTA_CIUDADES);
        }
        return datosDeCiudades;
    }
    
     */



    public List<Ladron> obtenerLadrones(String rutaArchivo) {
        List<Map<String,?> > ladronesLista = lectorDeJson.leerJson(rutaArchivo);

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

    @Override
    public List<ObjetoRobado> obtenerListadoDeObjetos() {
        if (objetosRobados == null) {
            objetosRobados = obtenerObjetosRobados(RUTA_OBJETOS);
        }
        return objetosRobados;
    }

    public List<ObjetoRobado> obtenerObjetosRobados(String rutaArchivo) {
        List<Map<String,?> > objetosLista = lectorDeJson.leerJson(rutaArchivo);

        Map<String,?> objetosMap;
        List<ObjetoRobado> objetos = new ArrayList<>();

        for (int i= 0; i < objetosLista.size();i++){
            objetosMap = objetosLista.get(i);
            ObjetoRobado objeto;

            if((objetosMap.get("valor")).equals("Comun")){
                objeto = new Comun((String) objetosMap.get("nombre"));
            }else if((objetosMap.get("valor")).equals("Valioso")){
                objeto = new Valioso((String) objetosMap.get("nombre"));
            }else {
                objeto = new MuyValioso((String) objetosMap.get("nombre"));
            }

            objetos.add(objeto);
        }
        return objetos;

    }


}




