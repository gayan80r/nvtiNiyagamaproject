package com.vtan.salesapp.salesapp.entity;
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


    @OneToMany( mappedBy = "genderId")
    private List<Employee> employeeList;

    @OneToMany( mappedBy = "genderid")
    private List<Accessor> accessorListList;

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
    public Gender(Integer id,String name)
    {
        this.id = id;
        this.name = name;
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
