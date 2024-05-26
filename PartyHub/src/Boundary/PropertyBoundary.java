package Boundary;

import Entity.*;
import Control.*;

import java.util.Scanner;

public class PropertyBoundary {
    private static Scanner sc = new Scanner(System.in);

    public static void showProperties(PropertyCtl propertyCtl) {
        propertyCtl.showProperties();
    }

    public static Property selectProperty(PropertyCtl propertyCtl) { 
        System.out.print("Digite o ID da propriedade que deseja ver: ");
        String id = sc.next();
        Property p =  propertyCtl.findProperty(id);
        if (p != null) {
            System.out.println("\n\n"+ p);
            return p;
        } else {
            System.out.println("Propriedade inexistente");
            return null;
        }
    }
}
