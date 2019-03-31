package com.laborator.proiect.services;

import com.laborator.proiect.auth.Authenticable;
import com.laborator.proiect.medic.Medic;
import com.laborator.proiect.model.User;
import com.laborator.proiect.patient.Patient;

import java.util.ArrayList;

public class UserService {
    private static UserService ourInstance = new UserService();

    public static UserService getInstance() {
        return ourInstance;
    }

    private static ArrayList<User> users;

    private UserService() {
        users = new ArrayList<>();
    }

    public boolean isAuth(Authenticable authenticable) {
        return authenticable.getToken().equals("Medical Room");
    }

    public static void addUser() {
        // TOBE ADDED
    }

    public static User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User getUser(Integer userId) {
        for (User user : users) {
            if (Medic.class == user.getClass()) {
                if (((Medic) user).getMedicDetails().getMedicId().equals(userId)) {
                    return user;
                }
            } else if (Patient.class == user.getClass()) {
                if (((Patient) user).getPatientDetails().getPatientId().equals(userId)) {
                    return user;
                }
            }
        }
        return null;
    }
}
