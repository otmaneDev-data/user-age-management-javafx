package org.iesalandalus.programacion.tp08.vista.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.iesalandalus.programacion.tp08.modelo.Usuario;
import org.iesalandalus.programacion.tp08.vista.utilidades.Controlador;
import org.iesalandalus.programacion.tp08.vista.utilidades.Controladores;
import org.iesalandalus.programacion.tp08.vista.utilidades.Dialogos;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;

import java.util.List;

public class VentanaPrincipal extends Controlador {

    @FXML
    private Label lbMensaje;

    @FXML
    private ListView<Usuario> lvUsuarios;

    @FXML
    public void initialize() {
        lvUsuarios.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, nuevo) -> mostrarMensaje(nuevo)
        );
    }

    public void setUsuarios(List<Usuario> usuarios) {
        lvUsuarios.getItems().addAll(usuarios);
    }

    @FXML
    public void acercaDe() {
        Controlador acercaDe = Controladores.get("/vistas/AcercaDe.fxml", "Acerca de", getEscenario());
        acercaDe.getEscenario().show();
    }

    @FXML
    public void salir() {
        Stage padre = getEscenario();
        if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que quieres salir de la aplicación?", padre)) {
            padre.close();
        }
    }

    private void mostrarMensaje(Usuario usuario) {
        if (usuario == null) {
            lbMensaje.setText("No has seleccionado ningún usuario");
        } else {
            lbMensaje.setText("@" + usuario.nick().substring(1) + " tiene " + usuario.edad() + " años");
        }
    }
}