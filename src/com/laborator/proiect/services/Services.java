package com.laborator.proiect.services;

import com.laborator.proiect.medic.Medic;
import com.laborator.proiect.model.Consultation;
import com.laborator.proiect.model.Medicine;
import com.laborator.proiect.model.User;
import com.laborator.proiect.patient.Patient;

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Services {
    private static Services ourInstance = new Services();

    public static Services getInstance() {
        return ourInstance;
    }

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Medic> medics = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Medicine> medicines = new ArrayList<>();

    private static PriorityQueue<Consultation> consultationPriorityQueue = new PriorityQueue<>();
    private static HashMap<LocalDate, Patient> consultationsDone = new HashMap<>();


    private Services() {
    }

    enum UserType {
        Medic, Patient;
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

    public static boolean addPatient(Patient patient, String username, String password) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);

        if (checkUsernameAvailable(username)) {
            if (checkPassword(password)) {
                patient.setUserName(username);
                patient.setHashPassword(password);
                patients.add(patient);
                return true;
            } else {
                System.out.println("INVALID PASSWORD");
            }
        } else {
            // Invalid username or password
            System.out.println("INVALID USERNAME");
        }
        return false;
    }

    public static boolean addMedic(Medic medic, String username, String password) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);
        if (checkUsernameAvailable(username)) {
            if (checkPassword(password)) {
                medic.setUserName(username);
                medic.setHashPassword(password);
                medics.add(medic);
                return true;
            } else {
                System.out.println("INVALID PASSWORD");
                return false;
            }
        } else {
            System.out.println("INVALID USERNAME");
            return false;
        }
    }

    /**
     * Checks if the password has the requirements.
     *
     * @param password
     * @return
     */
    private static boolean checkPassword(String password) {
        if (password.length() <= 6) {
            return false; // Password too short.
        } else for (int i = 0; i < password.length(); i++) {
            if (Character.isWhitespace(password.charAt(i))) {
                return false; // Password has whitespace.
            }
        }
        return true;
    }

    /**
     * Checks if the username it's available.
     *
     * @param username
     * @return
     * Implemented into GUI Register
     */
    private static boolean checkUsernameAvailable(String username) {
        if (username.length() <= 6) {
            return false; // Username too short.
        } else {
            if (!patients.isEmpty()) {
                for (Patient patient : patients
                ) {
                    if (patient.getUserName().equals(username)) {
                        return false; // Username already added for patient.
                    }
                }
                for (Medic medic : medics
                ) {
                    if (medic.getUserName().equals(username)) {
                        return false; // Username already added for patient.
                    }
                }
            }

        }
        return true;
    }

    public static void addMedicine(Medicine medicine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);
        medicines.add(medicine);
    }

    public static User getUser(String username) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);
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

    public static User getUserMedic(Integer userId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);
        for (Medic user : medics) {
            if (Medic.class == user.getClass()) {
                if (user.getMedicDetails().getMedicId().equals(userId)) {
                    return user;
                }
            }
        }
        System.out.println("User not found\n");
        return null;
    }

    public static Patient getUserPatient(Integer userId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);
        for (Patient user : patients) {
            if (Patient.class == user.getClass()) {
                if (user.getPatientDetails().getPatientId().equals(userId)) {
                    return user;
                }
            }
        }
        System.out.println("User not found\n");
        return null;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);
        return tempPatientList;
    }


    public static void writeAllDataToCSV() {
        FileService.getInstance().writeObjectToFile(patients, "./files/patients.csv");
        FileService.getInstance().writeObjectToFile(medics, "./files/medics.csv");
        FileService.getInstance().writeObjectToFile(medicines, "./files/medicines.csv");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new Object() {
        }.getClass().getEnclosingMethod().getName()).append(",").append(new Timestamp(System.currentTimeMillis()));
        writeToAudit(stringBuilder);
    }

    public static void loadAllDataFromCSV() {
        patients = (ArrayList<Patient>) FileService.getInstance().readObjectFromFile("./files/patients.csv");
        medics = (ArrayList<Medic>) FileService.getInstance().readObjectFromFile("./files/medics.csv");
        medicines = (ArrayList<Medicine>) FileService.getInstance().readObjectFromFile("./files/medicines.csv");
    }

    private static void writeToAudit(StringBuilder stringBuilder) {
        FileAuditTextService.getInstance().writeTextToAudit(stringBuilder.toString(), "files/audit.csv");
    }
}
