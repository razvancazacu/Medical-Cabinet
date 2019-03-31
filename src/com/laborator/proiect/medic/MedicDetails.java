package com.laborator.proiect.medic;

import java.util.Date;

public class MedicDetails {
    private Integer medicId;
    private String address;
    private Date dateOfBirth;
    private String cnp;
    private String telephone;
    private String email;
    private String medicalField;

    public MedicDetails(Integer medicId, String address, Date dateOfBirth,
                        String cnp, String telephone,
                        String email, String medicalField) {
        this.medicId = medicId;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.cnp = cnp;
        this.telephone = telephone;
        this.email = email;
        this.medicalField = medicalField;
    }

    public Integer getMedicId() {
        return medicId;
    }

    public void setMedicId(Integer medicId) {
        this.medicId = medicId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMedicalField() {
        return medicalField;
    }

    public void setMedicalField(String medicalField) {
        this.medicalField = medicalField;
    }
}
