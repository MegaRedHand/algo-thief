package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.stream.Stream;

public class DescripcionSospechoso {

    private final HashMap<String, Rasgo> rasgos = new HashMap<>();

    public DescripcionSospechoso(Rasgo... rasgos) {
        this.agregar(rasgos);
    }

    public boolean coincideCon(DescripcionSospechoso otraDescripcion) {
        return rasgos.keySet().stream().allMatch(k ->
                this.obtenerRasgo(k).igualA(otraDescripcion.obtenerRasgo(k)));
    }

    public void agregar(DescripcionSospechoso otraDescripcion) {
        this.rasgos.putAll(otraDescripcion.rasgos);
    }

    public void agregar(Rasgo... rasgos) {
        Stream.of(rasgos).forEach(r -> this.rasgos.put(r.categoria(), r));
    }

    private Rasgo obtenerRasgo(String categoria) {
        return this.rasgos.getOrDefault(categoria, new Rasgo(categoria, null));
    }

    public String getPistaVehiculo() {
        return String.format("El ladrón se fue en un %s.", obtenerRasgo("vehiculo").toString());
    }

    public String getPistaHobby() {
        return String.format("Al ladrón le gusta el %s.", obtenerRasgo("hobby").toString());
    }

    public String getPistaOcupacion() {
        return String.format("El ladrón es %s.", obtenerRasgo("ocupacion").toString());
    }

    public String getPistaColorDePelo() {
        return String.format("El ladrón tiene pelo %s.", obtenerRasgo("colorDelPelo").toString());
    }

    public String getPistaSenias() {
        return String.format("El sospechoso %s.", obtenerRasgo("señasParticulares").toString());
    }

}
