package com.vtan.salesapp.salesapp.entity;

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
    @OneToMany( mappedBy = "civilStatusId")
    private List<Employee> employeeList;
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
    public CivilStatus(Integer id,String name)
    {
        this.id = id;
        this.name = name;
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

