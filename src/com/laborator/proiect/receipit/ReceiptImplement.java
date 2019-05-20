package com.laborator.proiect.receipit;


import com.laborator.proiect.model.Medicine;
import com.laborator.proiect.receipit.Receipt;

import java.util.ArrayList;

public class ReceiptImplement implements Receipt {
    private Integer receiptId ;
    private ArrayList<Medicine> medicine = new ArrayList<>();
    private String medicalPrescription;
    private Integer issuedByMedic ;

    @Override
    public ArrayList<Medicine> getMedicine() {
        return this.medicine;
    }

    @Override
    public String getMedicalPrescription() {
        return this.medicalPrescription;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReceiptImplement{");
        sb.append("medicine=").append(medicine);
        sb.append(", medicalPrescription='").append(medicalPrescription).append('\'');
        sb.append(", issuedByMedic='").append(issuedByMedic).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setMedicine(ArrayList<Medicine> medicine) {
        this.medicine = medicine;
    }

    public void setMedicalPrescription(String medicalPrescription, int medicId) {
        this.medicalPrescription = medicalPrescription;
        issuedByMedic = medicId;
    }
}
