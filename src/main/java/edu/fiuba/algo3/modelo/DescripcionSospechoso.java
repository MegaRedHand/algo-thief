package edu.fiuba.algo3.modelo;

public class DescripcionSospechoso {

    private String sexo;
    private String hobby;

    public DescripcionSospechoso conSexo(String sexo) {

        this.sexo = sexo;
        return this;
    }

    public DescripcionSospechoso conHobby(String hobby) {

        this.hobby = hobby;
        return this;
    }
}
