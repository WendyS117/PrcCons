
package com.mycompany.gym;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InventarioController {

    @FXML
    private TableView<Item> inventoryTable;

    @FXML
    private TableColumn<Item, String> nameColumn;

    @FXML
    private TableColumn<Item, Integer> quantityColumn;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField quantityField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    private ObservableList<Item> inventory = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        quantityColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getQuantity()).asObject());

        inventoryTable.setItems(inventory);

        addButton.setOnAction(e -> addItem());
        deleteButton.setOnAction(e -> deleteItem());
        updateButton.setOnAction(e -> updateItem());
        searchButton.setOnAction(e -> searchItem());
    }

    private void addItem() {
        String name = itemNameField.getText().trim();
        String quantityText = quantityField.getText().trim();

        if (!name.isEmpty() && !quantityText.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityText);
                inventory.add(new Item(name, quantity));
                clearFields();
            } catch (NumberFormatException e) {
                showAlert("Cantidad inválida. Por favor ingresa un número.");
            }
        } else {
            showAlert("Completa todos los campos.");
        }
    }

    private void deleteItem() {
        Item selected = inventoryTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            inventory.remove(selected);
        } else {
            showAlert("Selecciona un artículo para eliminar.");
        }
    }

    private void updateItem() {
        Item selected = inventoryTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String name = itemNameField.getText().trim();
            String quantityText = quantityField.getText().trim();
            if (!name.isEmpty() && !quantityText.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityText);
                    selected.setName(name);
                    selected.setQuantity(quantity);
                    inventoryTable.refresh();
                    clearFields();
                } catch (NumberFormatException e) {
                    showAlert("Cantidad inválida.");
                }
            } else {
                showAlert("Completa todos los campos.");
            }
        } else {
            showAlert("Selecciona un artículo para actualizar.");
        }
    }

    private void searchItem() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            inventoryTable.setItems(inventory);
            return;
        }

        ObservableList<Item> filtered = FXCollections.observableArrayList();
        for (Item item : inventory) {
            if (item.getName().toLowerCase().contains(searchTerm)) {
                filtered.add(item);
            }
        }

        inventoryTable.setItems(filtered);
    }

    private void clearFields() {
        itemNameField.clear();
        quantityField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
