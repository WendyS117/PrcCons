
package com.mycompany.gym;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RegistroEntradaUsuariosController {

    @FXML
    private TextField txtNumeroUsuario;

    @FXML
    private CheckBox chkVisita;

    @FXML
    private GridPane calendarioGrid;

    // Método para inicializar elementos si es necesario
    @FXML
    public void initialize() {
        // aquí podríamos meter lo del calendario
        System.out.println("Controlador inicializado correctamente.");
    }

    // nos falta un botón para guardar la entrada del usuario, creo
    @FXML
    public void guardarEntrada() {
        String numeroUsuario = txtNumeroUsuario.getText();
        boolean traeVisita = chkVisita.isSelected();

        if (numeroUsuario == null || numeroUsuario.trim().isEmpty()) {
            System.out.println("Número de usuario es obligatorio.");
            return;
        }

        System.out.println("Entrada registrada:");
        System.out.println("Usuario: " + numeroUsuario);
        System.out.println("Visita: " + (traeVisita ? "Sí" : "No"));

        // aquí iría lo de la base de datos
    }

    // Método para retroceder 
    @FXML
    public void retroceder() {
        System.out.println("Retrocediendo a la pantalla anterior...");
        // Aquí se podría cerrar la escena o cambiar a otra quizá también regresar al menú principal
    }
}
