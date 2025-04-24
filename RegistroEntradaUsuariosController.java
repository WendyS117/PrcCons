
package com.mycompany.gym;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistroEntradaUsuariosController {

    @FXML
    private TextField txtNumeroUsuario;

    @FXML
    private CheckBox chkVisita;

    @FXML
    private GridPane calendarioGrid;

    @FXML
    public void guardarEntrada() {
        String numeroUsuario = txtNumeroUsuario.getText().trim();
        boolean esVisita = chkVisita.isSelected();
        
        if(numeroUsuario.isEmpty()){
            System.out.println("Debes ingresar un numero de usuario.");
            return;
        }
        
        System.out.println("Entrada guardada para usuario: " + numeroUsuario +
                (esVisita ? " (Visita)" : " (Miembro)"));
    }

    @FXML
    public void retroceder(javafx.event.ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Pane root = loader.load();
            
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al cargar la escena del menu.");
        }
    }
}
