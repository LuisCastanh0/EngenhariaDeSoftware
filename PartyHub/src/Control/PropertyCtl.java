package Control;

import java.util.ArrayList;

import Entity.*;

public class PropertyCtl {
    // Lista de Users
    private ArrayList<Property> Properties;

    public PropertyCtl() {
        Properties = new ArrayList<>();
    }   

    // Mostra todas as propriedades
    public void showProperties() {
        for (Property Property : Properties) {
            System.out.println(Property);
        }
    }

    // Função p encontrar uma property 
    public Property findProperty(String id) {
        for (Property Property : Properties) {
            if (Property.getId().equals(id)) {
                return Property;
            }
        }
        return null;
    }

    // Função p adicionar uma property
    public void addProperty(Property property) {
        Properties.add(property);
    } 
}  
