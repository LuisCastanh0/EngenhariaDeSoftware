package Test;

import Entity.*;
import Control.*;
import Boundary.*;

import java.util.Scanner;

public class TestAlugar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Cria controlers
        UserCtl userctl = new UserCtl();
        PropertyCtl propertyCtl = new PropertyCtl();
        ReservationCtl reservationCtl = new ReservationCtl();
        
        // Cria boundaries
        UserBoundary userBoundary = new UserBoundary();
        PropertyBoundary propertyBoundary = new PropertyBoundary();
        ReservationBoundary reservationBoundary = new ReservationBoundary();

        // Popula sistema
        User user1 = new User("Fernando", "BocaDeFesta", "20", "Viadinho", "fernando@fernando");
        User user2 = new User("Maria", "4321", "21", "Feminino", "maria@maria");    
        userctl.addUser(user1);
        userctl.addUser(user2);

        Owner Luis = new Owner("Luis", "1234-5678", "luis@gmail.com", "Masculino", "21");
        Owner Julian = new Owner("Julian", "5678-1234", "julian@gmail.com", "Masculino","21");

        Property property1 = new Property("101", "Casa Luis", "Casa", "30", "150", Luis, "Casa simples no centro", "Proibido fumar", "Rua Eneas Pereira Barbante, 123");
        Property property2 = new Property("102","Salão Julian", "Salão de Festas", "80", "300", Julian, "Salão de festas perfeito para seu evento", "Proibido uso de drogas", "Av. Brigadeiro Faria Lima, 456");
        propertyCtl.addProperty(property1);
        propertyCtl.addProperty(property2);


        boolean exitProgram = false;
        while (!exitProgram) {
            // Fazer login
            User test_user = userBoundary.login(userctl);
            boolean userLoggedIn = (test_user != null);
            while (userLoggedIn) {
                // Mostrar propriedades
                propertyBoundary.showProperties(propertyCtl);

                // Selecionar propriedade
                Property test_property = propertyBoundary.selectProperty(propertyCtl);

                // Fazer reserva
                System.out.print("Deseja reservar essa propriedade? (s/n): ");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("s")) {
                    reservationBoundary.createReservation(test_user, test_property);
                } 

                // Perguntar se deseja ver mais propriedades ou sair
                System.out.print("Deseja ver mais propriedades? (s) ou sair? (n): ");
                answer = sc.next();
                if (answer.equalsIgnoreCase("n")) {
                    userLoggedIn = false;
                }
            }

            // Perguntar se deseja fazer login novamente ou sair do programa
            System.out.print("Deseja fazer login novamente? (s/n): ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("n")) {
                exitProgram = true;
            }
        }

        sc.close();
    }
}
