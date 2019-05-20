package com.laborator.proiect;


import com.laborator.proiect.medic.Medic;
import com.laborator.proiect.medic.MedicDetails;
import com.laborator.proiect.model.Consultation;
import com.laborator.proiect.model.Medicine;
import com.laborator.proiect.patient.Patient;
import com.laborator.proiect.patient.PatientDetails;
import com.laborator.proiect.services.FileService;
import com.laborator.proiect.services.Services;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        Services services = Services.getInstance();
        Services.loadAllDataFromCSV();
//
//        Services.addMedic(new Medic(new MedicDetails("Radu", "Radulescu",
//                "Bucharest",
//                LocalDate.parse("1970-03-12"),
//                "1223213212231",
//                "0753421515",
//                "firstDoc",
//                "cardiology"
//        )), "usernameMedic", "password");
//
//
//        Services.addPatient(new Patient(new PatientDetails(
//                "adress",
//                Double.parseDouble("70"),
//                Double.parseDouble("195"),
//                LocalDate.parse("1970-03-12"),
//                "12123213212231",
//                "13245657",
//                "email@#asodmas",
//                "Ione",
//                "Ton",
//                "Huiaz"
//        )), "usernamePatient", "password");
        System.out.println(Services.getUser("usernamePatient"));
////        System.out.println(Services.getUserPatient(1));
//        Services.addMedicine(new Medicine("Aspirina", "Nu utilizaţi ASPIRIN:\n" +
//                "\uF0B7 dacă sunteţi alergic la acidul acetilsalicilic sau la alţi salicilaţi sau la oricare dintre componentele\n" +
//                "acestui medicament (enumerate la pct. 6).\n" +
//                "\uF0B7 în cazul în care aţi avut un episod de astm bronşic sau aţi avut o reacţie alergică (de exemplu\n" +
//                "urticarie, angioedem, rinită severă, şoc) cauzate de administrarea acidului acetilsalicilic sau a\n" +
//                "unui medicament înrudit (în special a medicamentelor antiinflamatoare nesteroidiene).\n" +
//                "\uF0B7 dacă aveţi ulcer gastric sau intestinal (inclusiv ulcer duodenal).\n" +
//                "\uF0B7 dacă aveţi o afecţiune hemoragică sau un risc de sângerare.\n" +
//                "\uF0B7 dacă aveţi insuficienţă renală, insuficienţă hepatică sau insuficienţă cardiacă severă. "));

        Patient patient = (Patient) Services.getUser("usernamePatient");
        Objects.requireNonNull(patient).getMedicalFile().addConsultation(
                new Consultation(1, 1, LocalDate.parse("2019-05-12")
                ));
//        System.out.println(Services.getPatientsFromMedic((Medic) Services.getUser("usernameMedic")));

//        FileService.getInstance().writeObjectToFile(patient, "./files/patient.csv");
//        Patient patient1 = (Patient)FileService.getInstance().readObjectFromFile("./files/patient.csv");
//        System.out.println("patient:" + patient);
//        System.out.println("patient1:" + patient1);
//        System.out.println(Services.getMedicine("Aspirina"));
    /*    Scanner scanner = new Scanner(System.in);
        Patient patient = new Patient();

        String pattern = "dd/MM/yyyy";
        Date birthDate = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            birthDate = format.parse("31/12/1999");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PatientDetails patientDetails = new PatientDetails(
                "Lorem Ipsum Adress",
                86.5,
                190.0,
                birthDate,
                "1234567891011",
                "0123456879",
                "lorem@email.com",
                "John");
    }*/
        Services.writeAllDataToCSV();
    }
}
