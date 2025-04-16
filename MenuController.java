package com.mycompany.gym;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MenuController {

    @FXML
    private void openEntradaUsuarios(ActionEvent event) {
        cambiarEscena(event, "registro_entrada.fxml", "Registro de Entrada");
    }

    @FXML
    private void openNuevoUsuario(ActionEvent event) {
        cambiarEscena(event, "nuevo_usuario.fxml", "Nuevo Usuario");
    }

    @FXML
    private void openInventario(ActionEvent event) {
        cambiarEscena(event, "inventario.fxml", "Inventario");
    }

    @FXML
    private void openResumenUsuarios(ActionEvent event) {
        cambiarEscena(event, "resumen.fxml", "Resumen de Usuarios");
    }

    @FXML
    private void closeApp(ActionEvent event) {
        System.out.println("Cerrando la aplicación...");
        System.exit(0);
    }

    private void cambiarEscena(ActionEvent event, String fxmlArchivo, String tituloVentana) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlArchivo));
            Scene nuevaEscena = new Scene(loader.load());
            Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaActual.setScene(nuevaEscena);
            ventanaActual.setTitle(tituloVentana);
            ventanaActual.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + fxmlArchivo);
        }
    }
}
