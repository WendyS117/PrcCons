package com.mycompany.gym;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * Controlador para el menú principal
 */
public class MenuController {

    @FXML
    private void openMenu(ActionEvent event) {
        cambiarEscena(event, "/com/mycompany/gym/Menu.fxml", "Menú");
    }

    @FXML
    private void openRegistroUsuario(ActionEvent event) {
        cambiarEscena(event, "/com/mycompany/gym/RegistroUsuario.fxml", "Registro de Usuario");
    }

    @FXML
    private void openDatosGuardados(ActionEvent event) {
        cambiarEscena(event, "/com/mycompany/gym/DatosGuardados.fxml", "Datos Guardados");
    }

    @FXML
    private void openEntradaUsuarios(ActionEvent event) {
        cambiarEscena(event, "/com/mycompany/gym/RegistroEntradaUsuarios.fxml", "Registro de Entrada");
    }

    @FXML
    private void openInventario(ActionEvent event) {
        cambiarEscena(event, "/com/mycompany/gym/Inventario.fxml", "Inventario");
    }

    @FXML
    private void openResumenUsuarios(ActionEvent event) {
        cambiarEscena(event, "/com/mycompany/gym/ResumenUsuarios.fxml", "Resumen de Usuarios");
    }

    @FXML
    private void closeApp(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Carga una nueva escena desde el archivo FXML indicado.
     * @param event evento que dispara el cambio de escena
     * @param fxmlPath ruta absoluta dentro de resources al FXML
     * @param tituloVentana título que se mostrará en la ventana
     */
    private void cambiarEscena(ActionEvent event, String fxmlPath, String tituloVentana) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaActual.setScene(new Scene(root));
            ventanaActual.setTitle(tituloVentana);
            ventanaActual.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + fxmlPath);
        }
    }
}

