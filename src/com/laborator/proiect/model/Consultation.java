package com.laborator.proiect.model;

import com.laborator.proiect.medic.Medic;
import com.laborator.proiect.patient.Patient;
import com.laborator.proiect.receipit.ReceiptImplement;

import java.util.Date;

public class Consultation {
    private Patient patient;
    private Medic medic;
    private Date date;
    private ReceiptImplement receiptImplement;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ReceiptImplement getReceiptImplement() {
        return receiptImplement;
    }

    public void setReceiptImplement(ReceiptImplement receiptImplement) {
        this.receiptImplement = receiptImplement;
    }
}
