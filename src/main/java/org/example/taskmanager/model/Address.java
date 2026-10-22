package org.example.taskmanager.model;

import jakarta.persistence.*;



@Embeddable
public class Address {
    @Column(nullable = false)
    private String city;
    private  String state;
    private String  country;

    public Address(){
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
