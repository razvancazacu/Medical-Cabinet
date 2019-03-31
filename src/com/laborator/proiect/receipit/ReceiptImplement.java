package com.laborator.proiect.receipit;


import com.laborator.proiect.model.Medicine;
import com.laborator.proiect.receipit.Receipt;

public class ReceiptImplement implements Receipt {
    private Medicine medicine;
    private Double numberOfPices;
    private String medicalPrescription;

    @Override
    public Medicine getMedicine() {
        return this.medicine;
    }

    @Override
    public String getMedicalPrescription() {
        return this.medicalPrescription;
    }

    @Override
    public Double getNumberOfPieces() {
        return this.numberOfPices;
    }
}
