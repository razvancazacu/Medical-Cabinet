package com.laborator.proiect.receipit;

import com.laborator.proiect.model.Medicine;

import java.util.ArrayList;

public interface Receipt {
    ArrayList<Medicine> getMedicine();
    String getMedicalPrescription();

}
