package com.laborator.proiect.services;

import com.laborator.proiect.auth.Authenticable;
import com.laborator.proiect.medic.Medic;
import com.laborator.proiect.model.Consultation;
import com.laborator.proiect.model.Medicine;
import com.laborator.proiect.model.User;
import com.laborator.proiect.patient.MedicalFile;
import com.laborator.proiect.patient.Patient;
import com.laborator.proiect.patient.PatientDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Services {
    private static Services ourInstance = new Services();

    public static Services getInstance() {
        return ourInstance;
    }

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Medic> medics = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();

    private static ArrayList<Medicine> medicines = new ArrayList<>();


    private Services() {
    }

    enum UserType {
        Medic, Patient;
    }

    public static void addPatient(Patient patient, String username, String password) {
        if (checkUsername(username) && checkPassword(password)) {
            patient.setUserName(username);
            patient.setHashPassword(password);
            patients.add(patient);
        } else {
            // Invalid username or password
        }
    }

    public static void addMedic(Medic medic, String username, String password) {
        if (checkUsername(username) && checkPassword(password)) {
            medic.setUserName(username);
            medic.setHashPassword(password);
            medics.add(medic);
        } else {
            // Invalid username or password
        }
    }

    /**
     * Checks if the password has the requirements.
     *
     * @param password
     * @return
     */
    private static boolean checkPassword(String password) {
        return true;
    }

    /**
     * Checks if the username it's available.
     *
     * @param username
     * @return
     */
    private static boolean checkUsername(String username) {
        return true;
    }

    public static void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public static User getUser(String username) {
        for (User user : patients) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        for (User user : medics) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        System.out.println("User not found\n");
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
        System.out.println("User not found\n");
        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Medic> getMedics() {
        return medics;
    }

    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public static ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    /**
     * Return all the patients that had the respective medic.
     *
     * @param medic
     * @return
     */
    public static ArrayList<Patient> getPatientsFromMedic(Medic medic) {
        ArrayList<Patient> tempPatientList = new ArrayList<>();
        for (Patient patient :
                patients
        ) {
            for (Consultation consultation :
                    patient.getMedicalFile().getConsultationsList()
            ) {
                if (consultation.getMedicId() == medic.getMedicDetails().getMedicId()) {
                    tempPatientList.add(patient);
                    break;
                }
            }
        }
        return tempPatientList;
    }

    public static Medicine getMedicine(String name) {
        for (Medicine medicine : medicines
        ) {
            if (medicine.getName().equals(name)) {
                return medicine;
            }

        }
        System.out.println("Medicine not found.");
        return null;
    }

    public static void writeAllDataToCSV() {
        FileService.getInstance().writeObjectToFile(patients, "./files/patients.csv");
        FileService.getInstance().writeObjectToFile(medics, "./files/medics.csv");
        FileService.getInstance().writeObjectToFile(medicines, "./files/medicines.csv");

    }

    public static void loadAllDataFromCSV() {
        patients = (ArrayList<Patient>)FileService.getInstance().readObjectFromFile("./files/patients.csv");
        medics = (ArrayList<Medic>)FileService.getInstance().readObjectFromFile("./files/medics.csv");
        medicines = (ArrayList<Medicine>)FileService.getInstance().readObjectFromFile("./files/medicines.csv");

    }
}
