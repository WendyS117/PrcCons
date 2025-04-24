package com.mycompany.gym;

import javafx.beans.property.*;

public class Item {

    private final StringProperty name;
    private final IntegerProperty quantity;

    public Item(String name, int quantity) {
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String nombre) {
        name.set(nombre);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int cantidad) {
        quantity.set(cantidad);
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }
}

