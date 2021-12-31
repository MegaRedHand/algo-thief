package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.perifericos.LectorDeArchivos;
import edu.fiuba.algo3.perifericos.LectorJson;
import edu.fiuba.algo3.vista.VistaComputadora;
import edu.fiuba.algo3.vista.VistaFinalPartida;
import javafx.scene.control.Label;

import java.util.List;
import java.util.Map;

public class Juego {

    private final Algothief algothief;
    private static final Juego singleton = new Juego();
    private App app;

    private Juego() {
        Map<String, LectorJson> lectores = Map.of(
                "ciudades", new LectorJson("/datos/ciudades.json"),
                "ladrones", new LectorJson("/datos/ladrones.json"),
                "objetos", new LectorJson("/datos/objetos.json")
        );
        algothief = new Algothief(new LectorDeArchivos(lectores));
        algothief.asignarPolicia(new ContadorDeDificultad(new Novato(), 0));
    }

    public static Juego getInstance() {
        return singleton;
    }

    public void asignarApp(App app) {
        this.app = app;
    }

    private boolean checkFinalPartida() {
        if (!algothief.juegoAcabado()) {
            return false;
        }
        String resultado;
        if (algothief.juegoGanado()) {
            resultado = "Felicidades! Lograste atrapar al sospechoso con la orden de arresto correcta.";
        } else if (algothief.seAcaboElTiempo()) {
            resultado = "Se te acabó el tiempo y el sospechoso logró escapar.";
        } else {
            resultado = "El sospechoso fue atrapado, pero sin la orden de arresto a su nombre, no es posible arrestarlo.";
        }
        new VistaFinalPartida(app, resultado);
        return true;
    }

    public void comenzarJuego() {
        algothief.reset();
        algothief.generarEscenario(new RandomBuilder());
    }

    public void visitar(String nombreEdificio, Label label) {
        if (checkFinalPartida()) {
            return;
        }
        algothief.visitar(nombreEdificio);
        label.setText(String.format("[%s] %s", algothief.fechaActual(), algothief.pistaMasReciente()));
    }

    public void viajar(String nombreCiudad, Label label) {
        if (checkFinalPartida()) {
            return;
        }
        algothief.viajar(nombreCiudad);
        label.setText(String.format("[%s] Viajaste a %s.", algothief.fechaActual(), nombreCiudad));
    }

    public List<String> edificiosVisitables() {
        return algothief.edificiosVisitables();
    }

    public List<String> ciudadesVisitables() {
        return algothief.ciudadesVisitables();
    }


    public void cargarDatos(VistaComputadora vistaComputadora) {
        if (checkFinalPartida()) {
            return;
        }
        DescripcionSospechoso descripcion = new DescripcionSospechoso(
                new Rasgo("sexo", vistaComputadora.getSexo()),
                new Rasgo("hobby", vistaComputadora.getHobby()),
                new Rasgo("vehiculo", vistaComputadora.getVehiculo()),
                new Rasgo("cabello", vistaComputadora.getCabello())
        );

        algothief.cargarDatosSospechoso(descripcion);
        List<String> sospechosos = algothief.buscarSospechosos();
        String mensaje;
        if (sospechosos.size() == 0) {
            mensaje = "No se encontró ningún sospechoso.";
        } else if (sospechosos.size() == 1) {
            String nombre = sospechosos.get(0);
            algothief.emitirOrdenDeArresto(nombre);
            mensaje = String.format("El sospechoso buscado es: %s. Se emitió la orden para su arresto.", nombre);
        } else {
            mensaje = "Los sospechosos que coinciden con la descripción son: " + String.join(", ", sospechosos);
        }
        String horaActual = String.format("[%s] ", algothief.fechaActual());
        vistaComputadora.setTextoLabel(horaActual + mensaje);
    }

}
