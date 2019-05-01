package com.laborator.proiect.medic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class MedicDetails implements Serializable {
    private static Integer currentMedicID = 0;

    private Integer medicId;
    private String address;
    private LocalDate dateOfBirth;
    private String cnp;
    private String telephone;
    private String email;
    private String firstName;
    private String lastName;
    private String medicalField;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MedicDetails{");
        sb.append("medicId=").append(medicId);
        sb.append(", address='").append(address).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", cnp='").append(cnp).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", medicalField='").append(medicalField).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public MedicDetails(String firstName, String lastName, String address, LocalDate dateOfBirth,
                        String cnp, String telephone,
                        String email, String medicalField) {
        this.medicId = ++currentMedicID;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getMedicalField() {
        return medicalField;
    }

    public void setMedicalField(String medicalField) {
        this.medicalField = medicalField;
    }
}
