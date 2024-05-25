package Control;

import Entity.*;

public class ReservationCtl {
    int reserv_count = 0;
    // Cria reserva
    public void createReservation(User user, Property property, String date, String check_in, String check_out){ 
        Reservation reservation = new Reservation(createId(),user,date,check_in,check_out,property);
        property.addReservation(reservation); // Salva reserva na lista de reservas da propriedade
        user.addReservation(reservation); // Salva reserva na lista de reservas do usuario
    }

    public String createId(){ 
        // cria um Id único para a reserva
        String id = Double.toString(Math.pow(2,reserv_count));
        reserv_count = reserv_count + 1;
        return id;
    }

    // Remove reserva de proprierty

    // Remove reserva de user

}
