package Boundary;

import Entity.*;
import Control.*;

import java.util.Scanner;

public class PropertyBoundary {
    private Scanner sc = new Scanner(System.in);

    public void showProperties(PropertyCtl propertyCtl) {
        propertyCtl.showProperties();
    }

    public Property selectProperty(PropertyCtl propertyCtl) { 
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

        public void updateProperty(Property property, Scanner sc) {
        boolean exitMenu = false;
        while (!exitMenu) {
            System.out.println("Editando: " + property.getName());
            System.out.println("1. Mudar capacidade");
            System.out.println("2. Mudar nome");
            System.out.println("3. Mudar tipo");
            System.out.println("4. Mudar metros quadrados");
            System.out.println("5. Mudar descricão");
            System.out.println("6. Mudar restricoes");
            System.out.println("7. Mudar endereço");
            System.out.println("0. Sair");
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite a nova capacidade: ");
                    property.setCapacity(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Digite o novo nome: ");
                    property.setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Digite o novo tipo: ");
                    property.setType(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Digite o novo valor: ");
                    property.setSquare_meters(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Digite a nova descricão: ");
                    property.setAbout(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Digite as novas restricoes: ");
                    property.setRules(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Digite o novo endereço: ");
                    property.setAddress(sc.nextLine());
                    break;
                case 0:
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
