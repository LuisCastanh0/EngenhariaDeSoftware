package Control;

import Entity.*;

import java.util.ArrayList;

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

    public String createId(){ 
        // cria um Id único para a reserva
        String id = Double.toString(Math.pow(2,reserv_count));
        reserv_count = reserv_count + 1;
        return id;
    }

    public boolean isAvailable(Property property,Reservation reservation,User user) {
        if (check_property(property,reservation) && check_user(user,reservation)) {
          return true;  
        }
        else {
            return false; 
        }
    }

    public static boolean check_property(Property property,Reservation reservation) {
        ArrayList<Reservation> temp = property.getReservations();

        for (Reservation r : temp) {
            if(r.getDate().equals(reservation.getDate())) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_user(User user,Reservation reservation) {
        ArrayList<Reservation> temp = user.getReservations();
        for (Reservation r : temp) {
            if(r.getDate().equals(reservation.getDate())) {
                return false;
            }
        }
        return true;
    }

    // Para fazer uma reserva na propriedade x, percorre a lista de reservas de x e verifica se alguma reserva foi feita na data informada
        // Se bater, jogar no boundary data indisp
        // Se nao bater, fazer a reserva
    
    // Percorrer tbm lista do usuário e ver se ele nn tem outra reserva no mesmo dia

    // Cancelar reserva

}
