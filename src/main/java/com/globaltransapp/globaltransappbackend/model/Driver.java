package com.globaltransapp.globaltransappbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfEmployment;
    private int codeOfUser;

     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public int getCodeOfUser() {
        return codeOfUser;
    }

    public void setCodeOfUser(int codeOfUser) {
        this.codeOfUser = codeOfUser;
    }
}
