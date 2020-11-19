package com.vtan.salesapp.salesapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class StudentBatchCourse {
    private String firstName;
    private String lastName;
    private int status;
    private Date date;
    private String id;

    public StudentBatchCourse() {

    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public StudentBatchCourse(String firstName, String lastName,int status, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.status=status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
