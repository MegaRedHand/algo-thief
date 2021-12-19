package edu.fiuba.algo3.modelo;

import java.util.List;

public class DatosDeCiudad {
    private String nombre;
    private List<String> ColoresBandera;
    private String moneda;
    private String geografia;
    private String ptosReferencia;
    private String industrias;
    private String animales;
    private String personas;
    private String lenguaje;
    private String arte;
    private String religion;
    private String lider;
    private String otro;

    public DatosDeCiudad(List<String> datos){
        this.nombre = datos.get(0);
        this.moneda = datos.get(1);
        this.geografia = datos.get(2);
        this.ptosReferencia = datos.get(3);
        this.industrias = datos.get(4);
        this.animales = datos.get(5);
        this.personas =datos.get(6);
        this.lenguaje = datos.get(7);
        this.arte =datos.get(8);
        this.religion = datos.get(9);
        this.lider = datos.get(10);
        this.otro = datos.get(11);
    }

}
