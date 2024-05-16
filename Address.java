public class Address {
    public String country;
    public String state;
    public String city;
    public String district;
    public String street;
    public String number;

    public Address(String country, String state, String city, String district, String street, String number) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address:" + country + ", " + state + ", " + city + ", " + district
                + ", " + street + ", " + number;
    }


}

