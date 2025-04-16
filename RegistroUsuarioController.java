package com.mycompany.gym;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RegistroUsuarioController {

    @FXML private TextField nombreField;
    @FXML private TextField apellidoPaternoField;
    @FXML private TextField apellidoMaternoField;
    
    @FXML private DatePicker fechaNacimientoPicker;
    
    @FXML private RadioButton femeninoRadio;
    @FXML private RadioButton masculinoRadio;
    @FXML private RadioButton otroRadio;
    private ToggleGroup sexoGroup;
    
    @FXML private TextField calleField;
    @FXML private TextField coloniaField;
    @FXML private TextField codigoPostalField;
    
    @FXML private TextField telefonoField;
    
    @FXML private RadioButton mensualRadio;
    @FXML private RadioButton trimestralRadio;
    @FXML private RadioButton semestralRadio;
    @FXML private RadioButton anualRadio;
    private ToggleGroup suscripcionGroup;
    
    @FXML private Button guardarButton;
    

    public void initialize() {
        sexoGroup = new ToggleGroup();
        femeninoRadio.setToggleGroup(sexoGroup);
        masculinoRadio.setToggleGroup(sexoGroup);
        otroRadio.setToggleGroup(sexoGroup);
        
        suscripcionGroup = new ToggleGroup();
        mensualRadio.setToggleGroup(suscripcionGroup);
        trimestralRadio.setToggleGroup(suscripcionGroup);
        semestralRadio.setToggleGroup(suscripcionGroup);
        anualRadio.setToggleGroup(suscripcionGroup);
        
        guardarButton.setOnAction(e -> guardarRegistro());
    }

    private void guardarRegistro(){
        String nombre = nombreField.getText();
        String apellidoP = apellidoPaternoField.getText();
        String apellidoM = apellidoMaternoField.getText();
        String fechaNac = (fechaNacimientoPicker.getValue() != null) ? fechaNacimientoPicker.getValue().toString() : "";
        RadioButton sexoSeleccionado = (RadioButton) sexoGroup.getSelectedToggle();
        String sexo = (sexoSeleccionado != null) ? sexoSeleccionado.getText() : "";
        
        String calle = calleField.getText();
        String colonia = coloniaField.getText();
        String codigoPostal = codigoPostalField.getText();
        String telefono = telefonoField.getText();
        
        RadioButton suscripcionSeleccionada = (RadioButton) suscripcionGroup.getSelectedToggle();
        String suscripcion = (suscripcionSeleccionada != null) ? suscripcionSeleccionada.getText() : "";
        
        if (nombre.isEmpty() || apellidoP.isEmpty() || apellidoM.isEmpty() || fechaNac.isEmpty() ||
                sexo.isEmpty() || calle.isEmpty() || colonia.isEmpty() || codigoPostal.isEmpty() ||
                telefono.isEmpty() || suscripcion.isEmpty()){
            
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos Incompletos");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, complete todos los campos.");
            alerta.showAndWait();
            return;
        }
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DatosGuardados.fxml"));
            
            Parent root = loader.load();
            
            DatosGuardadosController controller = loader.getController();
            controller.mostraDatos(
                nombre + " " + apellidoP + " " + apellidoM,
                fechaNac,
                sexo,
                calle + ", " + colonia + ", CP: " + codigoPostal,
                telefono,
                suscripcion
            );
            
            Stage stage = new Stage();
            stage.setTitle("Datos Guardados");
            stage.setScene(new Scene(root));
            stage.show();
            
            ((Stage) guardarButton.getScene().getWindow()).close();
        } catch (IOException ex){
            ex.printStackTrace();
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No se pudo abrir la ventana de datos guardados.");
            alerta.setContentText("Detalles: " + ex.getMessage());
            alerta.showAndWait();
        }
    }
}

