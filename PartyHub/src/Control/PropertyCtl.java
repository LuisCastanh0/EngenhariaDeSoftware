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
    
    public ArrayList<Property> getProperties() {
        return Properties;
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


    // Função para encontrar todas as propriedades de um Owner especifico
    public ArrayList<Property> findPropertiesByOwner(Owner owner) {
        ArrayList<Property> properties = new ArrayList<>();
        for (Property property : Properties) {
            if (property.getOwner().equals(owner)) {
                properties.add(property);
            }
        }
        return properties;
    }
}  
