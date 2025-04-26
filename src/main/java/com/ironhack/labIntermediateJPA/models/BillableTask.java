package com.ironhack.labIntermediateJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "billable_task")
public class BillableTask extends Task{

    @Column(name = "hourly_rate")
    private double hourlyRate;

    public BillableTask() {

    }

    public BillableTask(String title, Date dueDate, boolean status, double hourlyRate) {
        super(title, dueDate, status);
        setHourlyRate(hourlyRate);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "BillableTask {\n" +
                "    id=" + getId() + ",\n" +
                "    title='" + getTitle() + "',\n" +
                "    dueDate=" + getDueDate() + ",\n" +
                "    status=" + getStatus() + ",\n" +
                "    hourlyRate=" + hourlyRate + "\n" +
                "}";
    }
}
