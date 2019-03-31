package com.laborator.proiect.patient;

import java.util.Date;

public class PatientDetails {

    private Integer patientId;
    private String address;
    private Double weight;
    private Double height;
    private Date dateOfBirth;
    private String cnp;
    private String telephone;
    private String email;
    private String fatherFirstName;

    public PatientDetails(Integer patientId, String address, Double weight, Double height,
                          Date dateOfBirth, String cnp, String telephone,
                          String email, String fatherFirstName) {
        this.patientId = patientId;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.cnp = cnp;
        this.telephone = telephone;
        this.email = email;
        this.fatherFirstName = fatherFirstName;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
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

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }
}
