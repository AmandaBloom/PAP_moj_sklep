package pap;

import javafx.beans.property.SimpleStringProperty;

public class Address {
    private SimpleStringProperty id;
    private SimpleStringProperty postal;
    private SimpleStringProperty street;
    private SimpleStringProperty st_num;
    private SimpleStringProperty city;
    private SimpleStringProperty country;

    public Address(String id,String postal, String street, String st_num, String city, String country) {
        this.id = new SimpleStringProperty(id);
        this.postal = new SimpleStringProperty(postal);
        this.street = new SimpleStringProperty(street);
        this.st_num = new SimpleStringProperty(st_num);
        this.city = new SimpleStringProperty(city);
        this.country = new SimpleStringProperty(country);
    }

    public Address(){

    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getStreet() {
        return street.get();
    }

    public SimpleStringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getPostal() {
        return postal.get();
    }

    public SimpleStringProperty adressProperty() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal.set(postal);
    }

    public String getSt_num() {
        return st_num.get();
    }

    public SimpleStringProperty st_numProperty() {
        return st_num;
    }

    public void setSt_num(String st_num) {
        this.st_num.set(st_num);
    }
    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }
    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }


}
