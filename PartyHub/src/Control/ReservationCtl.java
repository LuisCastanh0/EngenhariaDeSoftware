package Control;

import Entity.*;

import java.util.ArrayList;
import java.util.Iterator;

public class ReservationCtl {
    int reserv_count = 0;
    // Cria reserva
    public boolean createReservation(User user, Property property, String date, String check_in, String check_out){ 
        Reservation reservation = new Reservation(createId(),user,date,check_in,check_out,property);
        if (isAvailable(property,reservation,user)) {
            property.addReservation(reservation); // Salva reserva na lista de reservas da propriedade
            user.addReservation(reservation); // Salva reserva na lista de reservas do usuario
            return true;
        }
        else {
            return false;
        }
    }

    // Gera um Id único para a reserva - numdereservas^2
    public String createId(){ 
        String id = Double.toString(Math.pow(2,reserv_count));
        reserv_count = reserv_count + 1;
        return id;
    }

    // Função para verificar se uma reserva pode ser feita pelo user na data especificada
    public boolean isAvailable(Property property,Reservation reservation,User user) {
        if (check_property(property,reservation) && check_user(user,reservation)) {
          return true;  
        }
        else {
            return false; 
        }
    }

    // Verifica se as datas das reservas em uma propriedade coincidem com a da reserva que será feita
    public static boolean check_property(Property property,Reservation reservation) {
        ArrayList<Reservation> temp = property.getReservations();

        for (Reservation r : temp) {
            if(r.getDate().equals(reservation.getDate())) {
                return false; // Se sim, retorna falso, a reserva não pode ser feita
            }
        }
        return true; // Se não, retorna true, reserva pode ser feita 
    }

    // Verifica se o usuário fazendo a reserva possui outras reservas na mesma data
    public static boolean check_user(User user,Reservation reservation) {
        ArrayList<Reservation> temp = user.getReservations();
        for (Reservation r : temp) {
            if(r.getDate().equals(reservation.getDate())) {
                return false; // Se sim, a reserva não pode ser feita
            }
        }
        return true; // Se não, a reserva pode ser feita
    }
    
    // Cancelar reserva
    public boolean cancelReservation(User user, String reservationId) {
        // Encontra a reserva com base no ID fornecido
        Reservation reservationToRemove = null;
        for (Reservation reservation : user.getReservations()) {
            if (reservation.getId().equals(reservationId)) {
                reservationToRemove = reservation;
                break;
            }
        }

        // Se a reserva foi encontrada, remove-a
        if (reservationToRemove != null) {
            Property property = reservationToRemove.getProperty();
            removeReservation_User(user, reservationToRemove);
            removeReservation_Property(property, reservationToRemove);
            return true;
        } else {
            return false; // Reserva não encontrada com o ID fornecido
        }
    }

    // Remove uma reserva na lista do usuário
    public void removeReservation_User(User user, Reservation reservation) {
        Iterator<Reservation> iterator = user.getReservations().iterator();
        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getId().equals(reservation.getId())) {
                iterator.remove();
                break;
            }
        }
    }

    // Remove uma reserva na lista da propriedade
    public void removeReservation_Property(Property property, Reservation reservation) {
        Iterator<Reservation> iterator = property.getReservations().iterator();
        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getId().equals(reservation.getId())) {
                iterator.remove();
                break;
            }
        }
    }


}
