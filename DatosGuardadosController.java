
package com.mycompany.gym;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author PC
 */
public class DatosGuardadosController{
    
    @FXML
    private Label lblNombre;
    
    @FXML
    private Label lblFechaNacimiento;
    
    @FXML 
    private Label lblSexo;
    
    @FXML
    private Label lblDomicilio;
    
    @FXML
    private Label lblTelefono;
    
    @FXML
    private Label lblSuscripcion;
    
    public void mostraDatos(String nombre, String fechaNacimiento, String sexo, String domicilio, String telefono, String suscripcion){
        lblNombre.setText(nombre);
        lblFechaNacimiento.setText(fechaNacimiento);
        lblSexo.setText(sexo);
        lblDomicilio.setText(domicilio);
        lblTelefono.setText(telefono);
        lblSuscripcion.setText(suscripcion);
    }
}
