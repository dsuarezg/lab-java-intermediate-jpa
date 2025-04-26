package com.ironhack.labIntermediateJPA.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Name name;

    @Column(name = "title")
    private String title;

    @Column (name = "company")
    private String company;

    public Contact() {

    }

    public Contact(Name name, String title, String company) {
        setName(name);
        setTitle(title);
        setCompany(company);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Contact {\n" +
                "    id=" + id + ",\n" +
                "    name=" + name + ",\n" +
                "    title='" + title + "',\n" +
                "    company='" + company + "'\n" +
                "}";
    }
}
