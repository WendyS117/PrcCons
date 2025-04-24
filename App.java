package com.mycompany.gym;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage primaryStage;
    private static final Map<String, Parent> scenes = new HashMap<>();
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        
        scenes.put("menu", loadFXML("menu.fxml"));
        scenes.put("registroUsuario", loadFXML("RegistroUsuario.fxml"));
        scenes.put("datosGuardados", loadFXML("DatosGuardados.fxml"));
        scenes.put("entradaUsuarios", loadFXML("RegistroEntradaUsuarios.fxml"));
        scenes.put("inventario", loadFXML("Inventario.fxml"));
        scenes.put("resumenUsuarios", loadFXML("ResumenUsuarios.fxml"));
        
        primaryStage.setTitle("Sistema de Gimnasio");
        primaryStage.setScene(new Scene(scenes.get("menu")));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void setScene(String name) {
        Parent root = scenes.get(name);
        if (root != null) {
            primaryStage.getScene().setRoot(root);
        } else {
            System.out.println("La escena '" + name + "' no está cargada.");
        }
    }

    private Parent loadFXML(String fxmlFile) throws Exception {
        String fullPath = "/com/mycompany/gym/" + fxmlFile;
        var fxmlURL = getClass().getResource(fullPath);
        if (fxmlURL == null) {
            throw new IllegalStateException("No se pudo encontrar el archivo FXML: " + fullPath);
        }
        FXMLLoader loader = new FXMLLoader(fxmlURL);
        return loader.load();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
