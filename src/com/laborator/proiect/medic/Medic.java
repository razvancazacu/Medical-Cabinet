package com.laborator.proiect.medic;

import com.laborator.proiect.model.User;
import com.laborator.proiect.patient.PatientDetails;

public class Medic extends User {
    private PatientDetails medicDetails;

    public PatientDetails getMedicDetails() {
        return medicDetails;
    }

    public void setMedicDetails(PatientDetails patientDetails) {
        this.medicDetails = patientDetails;
    }
}
