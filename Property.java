// TODO - Função para atualizar calendário quando User chamar o método addReservation.

public class Property {
    public String id;
    public String name;
    public String type;
    public int capacity;
    public int square_meters;
    public Owner owner;
    public String about;
    public String rules;
    public Calendar available_dates;
    public Address address;
    public Reservation[] Reservations;
    public int Reservation_counter=0;

    public Property(String id,String name, String type, int capacity, int square_meters, Owner owner, String about, String rules, Address address) {
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
        this.Reservations = new Reservation[40];
        
    }

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSquare_meters() {
        return square_meters;
    }

    public void setSquare_meters(int square_meters) {
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

    public void getReservations() {
        for (int i=0;i < Reservations.length;i++) {
            System.out.println(Reservations[i]);
        }
    }

    public void addReservation(Reservation reservation) {
        Reservations[Reservation_counter] = reservation;
        Reservation_counter++;
    }
    
    // Função para cancelar uma reserva específica pelo id da reserva.
    // Precisa remover reserva da lista de reservas do usuário tbm.


    @Override
    public String toString() {
        return name;
    }

}
