package com.laborator.proiect.services;

import com.laborator.proiect.auth.Authenticable;

public class UserService {
    private static UserService ourInstance = new UserService();

    public static UserService getInstance() {
        return ourInstance;
    }

    private UserService() {
    }

    public boolean isAuth(Authenticable authenticable) {
        return authenticable.getToken().equals("Medical Room");
    }
}
