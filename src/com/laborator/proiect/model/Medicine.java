package com.laborator.proiect.model;

import java.io.Serializable;

public class Medicine implements Serializable {
    private static long medicineId =0;
    private String name;
    private String prescription;
    private long id;

    public Medicine(String name, String prescription) {
        this.name = name;
        this.prescription = prescription;
        this.id = ++medicineId;
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medicine{");
        sb.append("name='").append(name).append('\'');
        sb.append(", prescription='").append(prescription).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
