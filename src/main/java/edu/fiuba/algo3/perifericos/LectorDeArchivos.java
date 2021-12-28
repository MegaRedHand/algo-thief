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
    private List<Comun> objetosComunes = new ArrayList<Comun>();
    private List<Valioso> objetosValiosos = new ArrayList<Valioso>();
    private List<MuyValioso> objetosMuyValiosos = new ArrayList<MuyValioso>();


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
    public List<Comun> obtenerObjetosComunes() {
        return objetosComunes;
    }

    @Override
    public List<Valioso> obtenerObjetosValiosos() {
        return objetosValiosos;
    }

    @Override
    public List<MuyValioso> obtenerObjetosMuyValiosos() {
        return objetosMuyValiosos;
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



    public void obtenerObjetosRobados() {

        List<Map<String,?> > objetosLista = lectorDeJson.leerJson(this.rutaObjetos);

        for (Map<String,?> objetoMap : objetosLista){

            if((objetoMap.get("valor")).equals("Comun")){
                Comun objetoComun = new Comun((String) objetoMap.get("tesoro"),(String) objetoMap.get("ciudad"));
                objetosComunes.add(objetoComun);
            }else if((objetoMap.get("valor")).equals("Valioso")){
                Valioso objetoValioso = new Valioso((String) objetoMap.get("tesoro"),(String) objetoMap.get("ciudad"));
                objetosValiosos.add(objetoValioso);
            }else {
                MuyValioso objetoMuyValioso = new MuyValioso((String) objetoMap.get("tesoro"),(String) objetoMap.get("ciudad"));
                objetosMuyValiosos.add(objetoMuyValioso);
            }


        }
    }


}




