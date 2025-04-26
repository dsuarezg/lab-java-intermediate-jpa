package com.ironhack.labIntermediateJPA.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Task {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "status")
    private boolean status;

    public Task() {
    }

    public Task(String title, Date dueDate, boolean status) {
        setTitle(title);
        setDueDate(dueDate);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task {\n" +
                "    id=" + id + ",\n" +
                "    title='" + title + "',\n" +
                "    dueDate=" + dueDate + ",\n" +
                "    status=" + status + "\n" +
                "}";
    }
}