package com.vtan.salesapp.salesapp.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private  String name;

    @JsonIgnore
    @OneToMany( mappedBy = "genderId")
    private List<Employee> employeeList;
    @JsonIgnore
    @OneToMany( mappedBy = "genderid")
    private List<Accessor> accessorListList;
    @JsonIgnore
    @OneToMany( mappedBy = "genderId")
    private List<RegistedStudent> registedStudentList;

    public List<RegistedStudent> getRegistedStudentList() {
        return registedStudentList;
    }

    public void setRegistedStudentList(List<RegistedStudent> registedStudentList) {
        this.registedStudentList = registedStudentList;
    }

    public List<Accessor> getAccessorListList() {
        return accessorListList;
    }

    public void setAccessorListList(List<Accessor> accessorListList) {
        this.accessorListList = accessorListList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Gender()//default class first create default constructor
    {

    }
    public Gender(Integer id,String name,List<Employee> employeeList,List<Accessor> accessorListList,List<RegistedStudent> registedStudentList)
    {
        this.id = id;
        this.name = name;
        this.registedStudentList = registedStudentList;
        this.employeeList = employeeList;
        this.accessorListList = accessorListList;
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
    @Override
    public String toString(){

        return  name;
    }
}
