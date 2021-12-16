package edu.fiuba.algo3.modelo;

public class DescripcionSospechoso {

    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public DescripcionSospechoso() {
        nombre = "";
        sexo = "";
        hobby = "";
        cabello = "";
        senia = "";
        vehiculo = "";
    }

    public DescripcionSospechoso(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo) {

        this.nombre = nombre;
        this.sexo = sexo;
        this.hobby = hobby;
        this.cabello = cabello;
        this.senia = senia;
        this.vehiculo = vehiculo;
    }

    public DescripcionSospechoso conSexo(String sexo) {

        this.sexo = sexo;
        return this;
    }

    public DescripcionSospechoso conHobby(String hobby) {

        this.hobby = hobby;
        return this;
    }

    public DescripcionSospechoso conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String nombre() {
        return this.nombre;
    }

    public boolean coincideCon(DescripcionSospechoso otraDescripcion) {

        // TODO: mejorar este asco de solución
        // Se me ocurre un patrón composite, con una función categoria que devuelve "hobby", "seña", etc; y guardarlo en un hashmap
        String[] valores = new String[] { nombre, sexo, hobby, cabello, senia, vehiculo };
        String[] valoresOtro = new String[] { otraDescripcion.nombre, otraDescripcion.sexo, otraDescripcion.hobby,
                otraDescripcion.cabello, otraDescripcion.senia, otraDescripcion.vehiculo };
        for (int i = 0; i < 6; i++) {
            if (!valores[i].equals("") && !valores[i].equals(valoresOtro[i])) {
                return false;
            }
        }
        return true;
    }

    public DescripcionSospechoso agregar(DescripcionSospechoso otraDescripcion) {

        // TODO: mejorar este asco de solución
        String[] valores = new String[] { nombre, sexo, hobby, cabello, senia, vehiculo };
        String[] valoresOtro = new String[] { otraDescripcion.nombre, otraDescripcion.sexo, otraDescripcion.hobby,
                otraDescripcion.cabello, otraDescripcion.senia, otraDescripcion.vehiculo };
        for (int i = 0; i < 6; i++) {
            if (!valoresOtro[i].equals("")) {
                valores[i] = valoresOtro[i];
            }
        }
        return new DescripcionSospechoso(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]);
    }
}
