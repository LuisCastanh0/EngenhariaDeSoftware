//Feito por Enzo Bernal de Matos - 10402685

package Test;

import Entity.*;
import Control.*;
import Boundary.*;

import java.util.Scanner;

public class TestCancelarUser {
    public static void main(String[] args) {
        // Cria controladores e boundaries  
    	UserCtl userCtl = new UserCtl();
        PropertyCtl propertyCtl = new PropertyCtl();
        ReservationCtl reservationCtl = new ReservationCtl();
        
        // Cria boundaries
        UserBoundary userBoundary = new UserBoundary();
        ReservationBoundary reservationBoundary = new ReservationBoundary();
        
        // Popular sistema
        User user1 = new User("Fernando", "BocaDeFesta", "20", "Viadinho", "fernando@fernando");
        userCtl.addUser(user1);

        Owner Luis = new Owner("Luis", "1234", "1234-5678", "luis@gmail.com", "Masculino", "21");
        Owner Julian = new Owner("Julian", "1234", "5678-1234", "julian@gmail.com", "Masculino","21");

        Property property1 = new Property("101", "Casa Luis", "Casa", "30", "150", Luis, "Casa simples no centro", "Proibido fumar", "Rua Eneas Pereira Barbante, 123");
        Property property2 = new Property("102","Salão Julian", "Salão de Festas", "80", "300", Julian, "Salão de festas perfeito para seu evento", "Proibido uso de drogas", "Av. Brigadeiro Faria Lima, 456");
        propertyCtl.addProperty(property1);
        propertyCtl.addProperty(property2);
        
        reservationCtl.createReservation(user1, property1, "2024-06-01", "14:00", "12:00");
        reservationCtl.createReservation(user1, property2, "2024-07-03", "14:00", "12:00");
        
        // Login 
        User loggedInUser = userBoundary.login(userCtl);
        if (loggedInUser == null) {
            System.out.println("Login falhou. Encerrando o programa.");
            return;
        }

        // Mostrar as reservas do usuário
        reservationBoundary.showReservations(loggedInUser);

        // Solicita um id de uma das reserva e cancela - CancelarReservation(String id)
        Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID da reserva que deseja cancelar: ");
		String reservationId = sc.next();
    
		// Cancelar a reserva
		if (reservationCtl.cancelReservation(loggedInUser, reservationId)) {
			System.out.println("Reserva cancelada com sucesso.");
		} else {
			System.out.println("Reserva não encontrada com o ID fornecido.");
		}
		
        reservationBoundary.showReservations(loggedInUser);

        sc.close();
   } 

}
