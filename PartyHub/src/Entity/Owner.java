package Entity;
public class Owner {
    public String name;
    public String phone_number;
    public String email;
    public String sex;
    public String age;

    public Owner(String name, String phone_number, String email, String sex, String age) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.sex = sex;
        this.age = age;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
}
