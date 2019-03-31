package com.laborator.proiect.model;

import com.laborator.proiect.auth.Authenticable;

import java.util.Date;

public class User implements Authenticable {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    private String userName;
    private String hashPassword;


    @Override
    public String getHashPassword() {
        return hashPassword;
    }

    @Override
    public String getToken() {
        return Authenticable.DEFAULT_TOKEN;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append('}');
        return sb.toString();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
