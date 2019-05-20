package com.laborator.proiect.model;

public class Clinic {
    private static long clinicId = 0;
    private long id;
    private String name;
    private String country;
    private String state;
    private String city;

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clinic{");
        sb.append("id=").append(id);
        sb.append(", country='").append(country).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", streetNr='").append(streetNr).append('\'');
        sb.append('}');
        return sb.toString();
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    private String streetName;
    private String streetNr;

    public Clinic(String country, String state, String city, String streetName, String streetNr, String name) {

        this.name = name;
        this.id = ++clinicId;
        this.country = country;
        this.state = state;
        this.city = city;
        this.streetName = streetName;
        this.streetNr = streetNr;
    }
}
