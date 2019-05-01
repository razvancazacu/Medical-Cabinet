package com.laborator.proiect.patient;

import com.laborator.proiect.model.Consultation;

import java.util.List;

public class MedicalFile {
    private static long medicalFileId = 0;

    private long id;
    private long patientId;

    List<Consultation> consultationsList;

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public MedicalFile(List<Consultation> consultationsList, long patientId) {
        this.id = ++medicalFileId;
        this.patientId = patientId;
        this.consultationsList = consultationsList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Consultation> getConsultationsList() {
        return consultationsList;
    }

    public void addConsultation(Consultation consultation) {
        consultationsList.add(consultation);
    }
    public void setConsultationsList(List<Consultation> consultationsList) {
        this.consultationsList = consultationsList;
    }
}
