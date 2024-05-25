package Boundary;

import Entity.*;
import Control.*;

import java.util.Scanner;

public class PropertyBoundary {
    private PropertyCtl propertyCtl = new PropertyCtl();
    private Scanner sc = new Scanner(System.in);

    public void showProperties() {
        propertyCtl.showProperties();
    }

    public void selectProperty() { 
        System.out.println("Digite o ID da propriedade que deseja ver: ");
        String id = sc.next();
        Property p =  propertyCtl.findProperty(id);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Propriedade inexistente");
        }
    }
}
