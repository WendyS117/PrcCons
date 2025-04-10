package com.mycompany.mavenproject1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML private TextField nombreField;
    @FXML private TextField apellidoPaternoField;
    @FXML private TextField apellidoMaternoField;
    @FXML private DatePicker fechaNacimientoPicker;
    @FXML private TextField domicilioField;

    @FXML private RadioButton femeninoRB;
    @FXML private RadioButton masculinoRB;
    @FXML private RadioButton otroRB;
    
    private ToggleGroup genderGroup;

    public void initialize() {
        genderGroup = new ToggleGroup();
        femeninoRB.setToggleGroup(genderGroup);
        masculinoRB.setToggleGroup(genderGroup);
        otroRB.setToggleGroup(genderGroup);
    }

    @FXML
    private void handleRegistro() {
        // Aquí puedes procesar los datos del formulario
        System.out.println("Registro guardado.");
    }
}
