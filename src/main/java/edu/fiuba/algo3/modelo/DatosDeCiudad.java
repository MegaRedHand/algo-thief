package edu.fiuba.algo3.modelo;

import java.util.List;

public class DatosDeCiudad {
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
        this.moneda = datos.get(0);
        this.geografia = datos.get(1);
        this.ptosReferencia = datos.get(2);
        this.industrias = datos.get(3);
        this.animales = datos.get(4);
        this.personas =datos.get(5);
        this.lenguaje = datos.get(6);
        this.arte =datos.get(7);
        this.religion = datos.get(8);
        this.lider = datos.get(9);
        this.otro = datos.get(10);
    }

}
