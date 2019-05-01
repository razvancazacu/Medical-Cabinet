package com.laborator.proiect.patient;

import com.laborator.proiect.model.User;


public class Patient extends User {

    private PatientDetails patientDetails;
    private MedicalFile medicalFile ;

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("patientDetails=").append(patientDetails);
        sb.append(", medicalFile=").append(medicalFile);
        sb.append('}');
        return sb.toString();
    }
    public Patient(PatientDetails patientDetails) {
        this.patientDetails = patientDetails;
        this.medicalFile = new MedicalFile(this.patientDetails.getPatientId());
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
    }

    public PatientDetails getPatientDetails() {
        return patientDetails;

    }

    public void setPatientDetails(PatientDetails patientDetails) {
        this.patientDetails = patientDetails;
    }
}
