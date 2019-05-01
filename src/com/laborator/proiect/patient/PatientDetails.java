package com.laborator.proiect.patient;

import java.time.LocalDate;
import java.util.Date;

public class PatientDetails {
    private static Integer currentPatientID = 0;
    private Integer patientId;
    private String address;
    private Double weight;
    private Double height;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private String cnp;
    private String telephone;
    private String email;
    private String fatherFirstName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PatientDetails{");
        sb.append("patientId=").append(patientId);
        sb.append(", address='").append(address).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", cnp='").append(cnp).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", fatherFirstName='").append(fatherFirstName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public PatientDetails(String address, Double weight, Double height,
                          LocalDate dateOfBirth, String cnp, String telephone,
                          String email, String fatherFirstName, String firstName, String lastName) {
        this.patientId = ++currentPatientID;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
