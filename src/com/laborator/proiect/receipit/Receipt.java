package com.laborator.proiect.receipit;

import com.laborator.proiect.model.Medicine;

public interface Receipt {
    Medicine getMedicine();
    String getMedicalPrescription();
    Double getNumberOfPieces();

}
