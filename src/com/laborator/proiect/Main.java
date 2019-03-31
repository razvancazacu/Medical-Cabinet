package com.laborator.proiect;

import com.laborator.proiect.patient.Patient;
import com.laborator.proiect.services.UserService;

public class Main {

    public static void main(String[] args) {

        System.out.println(UserService.getInstance().isAuth(new Patient()));

    }
}
