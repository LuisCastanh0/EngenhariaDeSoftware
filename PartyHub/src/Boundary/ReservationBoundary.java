package Boundary;

import Entity.*;
import Control.*;

import java.util.Scanner;

public class ReservationBoundary {
    private ReservationCtl reservationCtl = new ReservationCtl();
    private Scanner sc = new Scanner(System.in);

    public void createReservation(User user, Property property) {
        System.out.println("Digite a data da reserva: ");
        String date = sc.next();
        System.out.println("Digite a hora de entrada: ");
        String check_in = sc.next();
        System.out.println("Digite a hora de saida: ");
        String check_out = sc.next();
        reservationCtl.createReservation(user, property, date, check_in, check_out);

        System.out.println("Reserva efetuada com sucesso");
    }
        
}
