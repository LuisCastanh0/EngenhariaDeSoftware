// Feito por Julian Teixeira - 10400765
package Test;

import Entity.*;
import Control.*;
import Boundary.*;

import java.util.Scanner;

public class TestGerenciarAlugueis {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // Cria controlers
        UserCtl userctl = new UserCtl();
        PropertyCtl propertyCtl = new PropertyCtl();
        ReservationCtl reservationCtl = new ReservationCtl();
        OwnerCtl ownerCtl = new OwnerCtl();
        
        // Cria boundaries
        UserBoundary userBoundary = new UserBoundary();
        PropertyBoundary propertyBoundary = new PropertyBoundary();
        ReservationBoundary reservationBoundary = new ReservationBoundary();
        OwnerBoundary ownerBoundary = new OwnerBoundary();
    
        // Popula sistema
        User user1 = new User("Fernando", "1234", "20", "Viadinho", "fernando@fernando");
        User user2 = new User("Maria", "4321", "21", "Feminino", "maria@maria");
        userctl.addUser(user1);
        userctl.addUser(user2);

        Owner Luis = new Owner("Luis","1234", "1234-5678", "luis@gmail.com", "Masculino", "21");
        Owner Julian = new Owner("Julian","1234", "5678-1234", "julian@gmail.com", "Masculino","21");
        ownerCtl.addOwner(Luis);
        ownerCtl.addOwner(Julian);

        Property property1 = new Property("101", "Casa Luis", "Casa", "30", "150", Luis, "Casa simples no centro", "Proibido fumar", "Rua Eneas Pereira Barbante, 123");
        Property property2 = new Property("102","Salão Julian", "Salão de Festas", "80", "300", Julian, "Salão de festas perfeito para seu evento", "Proibido uso de drogas", "Av. Brigadeiro Faria Lima, 456");
        Property property3 = new Property("103","Casa Julian", "Casa", "25", "100", Julian, "Próximo a Av Sumaré", "Proibido fumar, acesso aos quartos proibido", "Rua Palestra Italia, 1914");
        Property property4 = new Property("104","Bar Julian", "Bar", "60", "200", Julian, "Bar comfortavel", "Proibido brigas", "Haddock Lobo, 123");
        propertyCtl.addProperty(property1);
        propertyCtl.addProperty(property2);
        propertyCtl.addProperty(property3);
        propertyCtl.addProperty(property4);

        boolean exitProgram = false;
        while (!exitProgram) {
            // Login 
            Owner test_owner = ownerBoundary.login(ownerCtl);
            if (test_owner != null) {
                boolean exitPropertyMenu = false;
                while (!exitPropertyMenu) {
                    // Mostrar as propriedades do Owner
                    ownerBoundary.showProperties(test_owner, propertyCtl);

                    // Escolha uma pelo id
                    Property test_property = propertyBoundary.selectProperty(propertyCtl);
                    if (test_property != null) {
                        boolean exitEditMenu = false;
                        while (!exitEditMenu) {
                            // Menu com opções para alterar atributos da propriedade
                            propertyBoundary.updateProperty(test_property, sc);
                            System.out.print("Deseja editar outra propriedade? (s/n): ");
                            String editAnother = sc.nextLine();
                            if (editAnother.equalsIgnoreCase("n")) {
                                exitEditMenu = true; // Sai do menu
                            }
                        }
                    }
                    System.out.print("Deseja sair da lista de propriedades? (s/n): ");
                    String exitProperty = sc.nextLine();
                    if (exitProperty.equalsIgnoreCase("s")) {
                        exitPropertyMenu = true; // Reinicia o menu
                    }
                }
            }
            System.out.print("Deseja sair do programa? (s/n): ");
            String exitProg = sc.nextLine();
            if (exitProg.equalsIgnoreCase("s")) {
                exitProgram = true; // Finaliza a execução 
            }
        }
        sc.close();
    }
}
