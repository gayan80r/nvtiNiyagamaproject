package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employeetraining")
public class EmployeeTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private  String name;
    @Column(name="duration")
    private  String duration;

    @OneToMany(mappedBy = "emptraid")
    private List<EmployeeTrainingDetails> employeeTriningDetailsList;

    @OneToMany(mappedBy = "emptraid")
    private List<EmployeeTraingRequestDetails> employeeTraingRequestDetailsList;

    public EmployeeTraining(String name, String duration, List<EmployeeTrainingDetails> employeeTriningDetailsList) {
        this.id=id;
        this.name = name;
        this.duration = duration;
        this.employeeTriningDetailsList = employeeTriningDetailsList;
    }

    public List<EmployeeTraingRequestDetails> getEmployeeTraingRequestDetailsList() {
        return employeeTraingRequestDetailsList;
    }

    public void setEmployeeTraingRequestDetailsList(List<EmployeeTraingRequestDetails> employeeTraingRequestDetailsList) {
        this.employeeTraingRequestDetailsList = employeeTraingRequestDetailsList;
    }

    public EmployeeTraining() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<EmployeeTrainingDetails> getEmployeeTriningDetailsList() {
        return employeeTriningDetailsList;
    }

    public void setEmployeeTriningDetailsList(List<EmployeeTrainingDetails> employeeTriningDetailsList) {
        this.employeeTriningDetailsList = employeeTriningDetailsList;
    }

    @Override
    public String toString() {
        return name;
    }
}
