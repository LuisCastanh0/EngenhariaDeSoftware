public class User {
    public String id;
    public String name;
    public String age;
    public String sex;
    public String email;
    public Reservation[] Reservations;
    private int Reservation_counter = 0;
    
    public User(String id, String name, String age, String sex, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.Reservations = new Reservation[10];
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

    public void getReservations() {
       for (int i=0;i < Reservations.length;i++) {
           System.out.println(Reservations[i]);
       }
    }

    public String gen_idReservation(){ 
        int new_id = Reservation_counter + Integer.parseInt(id);
        return Integer.toString(new_id);
    }

    public void addReservation(Property property,String date,String check_in,String check_out) {
        Reservation newReservation = new Reservation(gen_idReservation(),name,date,check_in,check_out,property);
        // Adiciona reserva em Reservations de property
        property.addReservation(newReservation);
        Reservations[Reservation_counter] = newReservation;
        Reservation_counter++;
    }  


    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", sex=" + sex + ", email=" + email + "]";
    }

}
