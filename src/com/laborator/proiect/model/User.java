package com.laborator.proiect.model;

import com.laborator.proiect.auth.Authenticable;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class User implements Authenticable, Comparable<User>, Serializable {

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
        sb.append('}');
        return sb.toString();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    @Override
    public int compareTo(User o) {
        return this.getUserName().compareTo(o.getUserName());
    }
}
