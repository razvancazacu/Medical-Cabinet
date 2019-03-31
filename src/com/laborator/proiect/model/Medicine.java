package com.laborator.proiect.model;

public class Medicine {
    private String name;
    private String prescription;
    private Double price;

    public Medicine(String name, String prescription, Double price) {
        this.name = name;
        this.prescription = prescription;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
