package com.vtan.salesapp.salesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CivilStatus")
public class CivilStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private  String name;
    @JsonIgnore
    @OneToMany( mappedBy = "civilStatusId")
    private List<Employee> employeeList;
    @JsonIgnore
    @OneToMany( mappedBy = "civilStatusId")
    private List<RegistedStudent> registedStudentList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<RegistedStudent> getRegistedStudentList() {
        return registedStudentList;
    }

    public void setRegistedStudentList(List<RegistedStudent> registedStudentList) {
        this.registedStudentList = registedStudentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public CivilStatus()//default class first create default constructor
    {

    }
    public CivilStatus(Integer id,String name,List<Employee> employeeList,List<RegistedStudent> registedStudentList)
    {
        this.id = id;
        this.name = name;
        this.employeeList = employeeList;
        this.registedStudentList = registedStudentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return name;
                };
    }

