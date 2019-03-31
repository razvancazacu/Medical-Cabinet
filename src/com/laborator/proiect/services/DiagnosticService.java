package com.laborator.proiect.services;

import com.laborator.proiect.model.Receipt;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticService implements Service {
    private static DiagnosticService ourInstance = new DiagnosticService();

    private static List<Receipt> receipts;

    private static DiagnosticService getInstance() {
        return ourInstance;
    }

    private DiagnosticService() {

        receipts = new ArrayList<Receipt>();
    }


    @Override
    public void saveConsultation(Receipt receipt) {
        receipts.add(receipt);
    }
}
