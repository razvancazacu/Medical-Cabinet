package com.laborator.proiect.services;

import com.laborator.proiect.model.Consultation;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticService implements Diagnostic {
    private static DiagnosticService ourInstance = new DiagnosticService();

    private static List<Consultation> consultations;

    private static DiagnosticService getInstance() {
        return ourInstance;
    }

    private DiagnosticService() {
        consultations = new ArrayList<Consultation>();
    }


    @Override
    public void saveConsultation(Consultation consultation) {
        consultations.add(consultation);
    }
}
