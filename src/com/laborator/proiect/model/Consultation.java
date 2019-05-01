package com.laborator.proiect.model;

import com.laborator.proiect.medic.Medic;
import com.laborator.proiect.patient.Patient;
import com.laborator.proiect.receipit.ReceiptImplement;

import java.time.LocalDate;
import java.util.Date;

public class Consultation {
    private static Integer consultationNrId = 0;
    private Integer consultationID;
    private long patientId;
    private long medicId;
    private LocalDate date;
    private ReceiptImplement receiptImplement;
    public enum DiagType {
        SEVERE,
        LIGHT,
        ACUTE,
        CHRONIC,
        URGENT
    }

    public Consultation(long patientId, long medicId, LocalDate date) {
        this.consultationID = ++consultationNrId;
        this.patientId = patientId;
        this.medicId = medicId;
        this.date = date;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getMedicId() {
        return medicId;
    }

    public void setMedicId(long medicId) {
        this.medicId = medicId;
    }

    public Consultation() {
        this.consultationID = ++consultationNrId;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ReceiptImplement getReceiptImplement() {
        return receiptImplement;
    }

    public void setReceiptImplement(ReceiptImplement receiptImplement) {
        this.receiptImplement = receiptImplement;
    }

    public Integer getConsulationID() {
        return consultationID;
    }

}
