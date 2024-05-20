// TODO - Função para atualizar calendário quando User chamar o método addReservation.

import java.util.ArrayList;

public class Property {
    public String id;
    public String name;
    public String type;
    public String capacity;
    public String square_meters;
    public Owner owner;
    public String about;
    public String rules;
    public Calendar available_dates;
    public Address address;
    private ArrayList<Reservation> Reservations;
    public int Reservation_counter=0;

    // Construtor
    public Property(String id,String name, String type, String capacity, String square_meters, Owner owner, String about, String rules, Address address) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.square_meters = square_meters;
        this.owner = owner;
        this.about = about;
        this.rules = rules;
        this.available_dates = new Calendar();
        this.address = address;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSquare_meters() {
        return square_meters;
    }

    public void setSquare_meters(String square_meters) {
        this.square_meters = square_meters;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Calendar getAvailable_dates() {
        return available_dates;
    }

    public void setAvailable_dates(Calendar available_dates) {
        this.available_dates = available_dates;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Imprime uma lista com todas as reservas da propriedade
    public void getReservations() { 
        System.out.println("Reservas da propriedade " + name + ":");
        for (Reservation reservation : Reservations) {
            System.out.println(reservation);
        }
    }


    // Função para salvar uma nova reserva
    // Chamada pelo user ao fazer uma reserva
    public void addReservation(Reservation reservation) {
        Reservations.add(reservation);
        Reservation_counter++;
    }


    // Função para cancelar uma reserva específica pelo id da reserva.
    // Essa função é chamada pelo user ao cancelar uma reserva
    public boolean removeReservations_USER(String id){ 
        for (Reservation reservation : Reservations) {
            if(reservation.getId().equals(id)){ 
                Reservations.remove(reservation);
                Reservation_counter--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Property [id=" + id + ", name=" + name + "]";
    }

    // Método para mostrar todas as informações da propriedade
    public void showProperty() {
        System.out.println("\n" + name);
        System.out.println(type);
        System.out.println("Capacidade: " + capacity);
        System.out.println("Tamanho (m²): " + square_meters);
        System.out.println("Proprietário: " + owner.getName());
        System.out.println("Telefone proprietário: " + owner.getPhone_number());
        System.out.println("Sobre: " + about);
        System.out.println("Regras: " + rules);
        System.out.println(address);
    }

}
