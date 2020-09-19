package com.vtan.salesapp.salesapp.entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class highestVocationalQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private  String name;

    public highestVocationalQualification(String name) {
        this.name = name;
    }

    public highestVocationalQualification()//default class first create default constructor
    {

    }
    @OneToMany( mappedBy = "highset_vocational_qualification_id")
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
