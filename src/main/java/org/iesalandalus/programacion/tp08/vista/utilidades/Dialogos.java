package org.iesalandalus.programacion.tp08.vista.utilidades;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Dialogos {

    private Dialogos() {
    }

    public static boolean mostrarDialogoConfirmacion(String titulo, String mensaje, Stage propietario) {
        Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(null);
        dialogo.setContentText(mensaje);
        if (propietario != null) {
            dialogo.initOwner(propietario);
        }
        Optional<ButtonType> resultado = dialogo.showAndWait();
        return resultado.isPresent() && resultado.get() == ButtonType.OK;
    }
}