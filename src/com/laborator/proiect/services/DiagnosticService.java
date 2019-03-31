package com.laborator.proiect.services;

import com.laborator.proiect.model.Consultation;

import java.util.ArrayList;

public class DiagnosticService implements Diagnostic {
    private static DiagnosticService ourInstance = new DiagnosticService();

    private static ArrayList<Consultation> consultations;

    private static DiagnosticService getInstance() {
        return ourInstance;
    }

    private DiagnosticService() {
        consultations = new ArrayList<>();
    }

    public static Consultation getConsultation(Integer consultationID) {
        for (Consultation consultation : consultations) {
            if (consultation.getConsulationID().equals(consultationID)) {
                return consultation;
            }
        }
        return null;
    }

    @Override
    public boolean saveConsultation(Consultation consultation) {
        for (Consultation consultation1 :
                consultations) {
            if (consultation1.getConsulationID().equals(consultation.getConsulationID())) {
                System.out.println("The consultation is already added");
                return false;
            }
        }
        consultations.add(consultation);
        return true;
    }
}
