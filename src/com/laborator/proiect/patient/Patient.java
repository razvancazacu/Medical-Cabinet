package com.laborator.proiect.patient;

import com.laborator.proiect.model.User;

public class Patient extends User {

    private PatientDetails patientDetails;

    public PatientDetails getPatientDetails() {
        return patientDetails;
    }

    public void setPatientDetails(PatientDetails patientDetails) {
        this.patientDetails = patientDetails;
    }
}
