package org.iesalandalus.programacion.tp08;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.iesalandalus.programacion.tp08.modelo.Usuarios;
import org.iesalandalus.programacion.tp08.vista.controladores.VentanaPrincipal;
import org.iesalandalus.programacion.tp08.vista.utilidades.Controladores;
import org.iesalandalus.programacion.tp08.vista.utilidades.Dialogos;

public class Main extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        Usuarios usuarios = new Usuarios();
        usuarios.leer();

        VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) Controladores.get(
                "/vistas/VentanaPrincipal.fxml", "Edades Usuarios", null);
        ventanaPrincipal.setUsuarios(usuarios.getUsuarios());
        ventanaPrincipal.getEscenario().setOnCloseRequest(e -> salir(e));
        ventanaPrincipal.getEscenario().show();
    }

    public void salir(WindowEvent e) {
        Stage padre = (Stage) e.getSource();
        if (!Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que quieres salir de la aplicación?", padre)) {
            e.consume();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}