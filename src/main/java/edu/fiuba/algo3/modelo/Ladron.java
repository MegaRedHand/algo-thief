package edu.fiuba.algo3.modelo;

public class Ladron {

    private final String sexo;
    private final String nombre;
    private final Comun objetoRobado;
    private final DescripcionSospechoso descripcion;

    public Ladron(Comun objetoRobado, String sexo) {
        this.nombre = "Desconocido";
        this.sexo = sexo;
        this.objetoRobado = objetoRobado;
        this.descripcion = new DescripcionSospechoso(new Rasgo("Sexo", sexo));
    }

    public Ladron(String nombre, DescripcionSospechoso descripcion, Comun objetoRobado) {
        this.nombre = nombre;
        this.objetoRobado = objetoRobado;
        this.descripcion = descripcion;
        this.sexo = "";
    }

    public DescripcionSospechoso descripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

}