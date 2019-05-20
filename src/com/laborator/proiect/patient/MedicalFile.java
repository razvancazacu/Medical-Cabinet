package com.laborator.proiect.patient;

import com.laborator.proiect.model.Consultation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MedicalFile implements Serializable {
    private static long medicalFileId = 0;

    private long id;
    private long patientId;

    private List<Consultation> consultationsList = new ArrayList<>();

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
    public MedicalFile(long patientId) {
        this.id = ++medicalFileId;
        this.patientId = patientId;
    }
    public long getId() {
        return id;
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
