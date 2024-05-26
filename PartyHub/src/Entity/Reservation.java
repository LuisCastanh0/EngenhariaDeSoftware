package Entity;
public class Reservation {
    public String id;
    public User user;
    public String date;
    public String check_in;
    public String check_out;
    public Property property;

    // Construtor
    public Reservation(String id, User user, String date, String check_in, String check_out, Property property) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.check_in = check_in;
        this.check_out = check_out;
        this.property = property;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Reservation [user=" + user.getName() + ", date=" + date + property + "]";
    }
}
