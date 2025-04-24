package com.mycompany.gym;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResumenUsuariosController {

    @FXML
    private TableView<UsuarioResumen> tablaUsuarios;

    @FXML
    private TableColumn<UsuarioResumen, String> columnaNombre;

    @FXML
    private TableColumn<UsuarioResumen, String> columnaNumeroUsuario;

    @FXML
    private TableColumn<UsuarioResumen, String> columnaSuscripcion;

    private static final ObservableList<UsuarioResumen> listaUsuarios = FXCollections.observableArrayList();

    public static void agregarUsuario(String nombreCompleto, String numeroUsuario, String suscripcion) {
        listaUsuarios.add(new UsuarioResumen(nombreCompleto, numeroUsuario, suscripcion));
    }

    @FXML
    public void initialize() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaNumeroUsuario.setCellValueFactory(new PropertyValueFactory<>("numeroUsuario"));
        columnaSuscripcion.setCellValueFactory(new PropertyValueFactory<>("suscripcion"));

        tablaUsuarios.setItems(listaUsuarios);
    }
}



