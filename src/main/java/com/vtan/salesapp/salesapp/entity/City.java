package com.vtan.salesapp.salesapp.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private  String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cityId")
    private List<Employee> employeeList;
    @JsonIgnore
    @OneToMany(mappedBy = "cityId")
    private List<RegistedStudent> studentList;

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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<RegistedStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<RegistedStudent> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "name";
    }

    public City(Integer id,String name, List<Employee> employeeList, List<RegistedStudent> studentList) {
        this.id=id;
        this.name = name;
        this.employeeList = employeeList;
        this.studentList = studentList;
    }
    public City() {

    }
}

