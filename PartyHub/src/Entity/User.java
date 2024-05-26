package Entity;
import java.util.ArrayList;

public class User {
    public String name;
    public String password;
    public String age;
    public String sex;
    public String email;
    private ArrayList<Reservation> Reservations;
    public int Reservation_counter = 0;
    
    // Construtores
    public User(String name, String password, String age, String sex, String email) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.Reservations = new ArrayList<>();
    }  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }   

    public ArrayList<Reservation> getReservations() { 
        return Reservations;
    }

    // Função para salvar uma nova reserva, chamada pelo ctl
    public void addReservation(Reservation reservation) {
        Reservations.add(reservation);
        Reservation_counter++;
    }

    // Função para excluir(cancelar) uma reserva 
    public void removeReservations_USER(String id){ 
        for (Reservation reservation : Reservations) {
            if(reservation.getId().equals(id)){ 
                // Remove reserva da lista do user
                Reservations.remove(reservation);
                Reservation_counter--;

                // Remove reserva da lista da property
                reservation.getProperty().removeReservations_USER(id);
                break;
            }
        }
    }
}
