import java.util.ArrayList;

public class User {
    public String id;
    public String name;
    public String password;
    public String age;
    public String sex;
    public String email;
    private ArrayList<Reservation> Reservations;
    private int Reservation_counter = 0;
    
    // Construtores
    public User(String id, String name, String password, String age, String sex, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.Reservations = new ArrayList<>();
    }  


    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    // Imprime uma lista com todas as reservas
    public void getReservations() { 
        System.out.println("Reservas da propriedade " + name + ":");
        for (Reservation reservation : Reservations) {
            System.out.println(reservation);
        }
    }

    // Gera um id para a reserva
    public String gen_idReservation(){ 
        int new_id = Reservation_counter + Integer.parseInt(id) + 100;
        return Integer.toString(new_id);
    }

    // Função para salvar uma nova reserva
    public void addReservation(Property property,String date,String check_in,String check_out) {
        Reservation newReservation = new Reservation(gen_idReservation(),name,date,check_in,check_out,property);
        // Adiciona a reserva na lista de reservas de property
        property.addReservation(newReservation);
        
        // Adiciona a reserva na lista de reservas do user
        Reservations.add(newReservation);
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

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", Reservations=" + Reservations + "]";
    }
}
