package com.laborator.proiect.medic;

import com.laborator.proiect.model.User;
import com.laborator.proiect.patient.PatientDetails;

public class Medic extends User {
    private MedicDetails medicDetails;

    public MedicDetails getMedicDetails() {
        return medicDetails;
    }

    public void setMedicDetails(MedicDetails medicDetails) {
        this.medicDetails = medicDetails;
    }
}
