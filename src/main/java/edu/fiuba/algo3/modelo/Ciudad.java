package edu.fiuba.algo3.modelo;

public class Ciudad {

    private List<Edificio> edificios = new ArrayList<>();
    private String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public void visitarEdificio (String nombreEdificio) {
        Edificio edificio = self.buscarEdificio(nombreEdificio);
        edificio.visitar();
    }
}
