package com.ironhack.labIntermediateJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "internal_task")
public class InternalTask extends Task {

    public InternalTask() {

    }

    public InternalTask(String title, Date dueDate, boolean status) {
        super(title, dueDate, status);

    }


    @Override
    public String toString() {
        return "InternalTask {\n" +
                "    id=" + getId() + ",\n" +
                "    title='" + getTitle() + "',\n" +
                "    dueDate=" + getDueDate() + ",\n" +
                "    status=" + getStatus() + "\n" +
                "}";
    }

}
