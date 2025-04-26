package com.ironhack.labIntermediateJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class Name {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "salutation")
    private String salutation;

    public Name() {
    }

    public Name(String firstName, String lastName, String middleName, String salutation) {
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        setSalutation(salutation);
    }

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @Override
    public String toString() {
        return "Name {\n" +
                "    firstName='" + firstName + "',\n" +
                "    lastName='" + lastName + "',\n" +
                "    middleName='" + middleName + "',\n" +
                "    salutation='" + salutation + "'\n" +
                "}";
    }
}
