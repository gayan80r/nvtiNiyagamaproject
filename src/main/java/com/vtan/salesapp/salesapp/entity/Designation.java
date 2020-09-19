package com.vtan.salesapp.salesapp.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="designation")


public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private  Integer id;
    @Column(name="name")
    private  String name;

    @OneToMany( mappedBy = "designationId")
    //we want to list the employee list not a one
    private List<Employee> employeeList;

    @OneToMany( mappedBy = "designationid")
    //we want to list the employee list not a one
    private List<Accessor> accessorList;

    public List<Accessor> getAccessorList() {
        return accessorList;
    }

    public void setAccessorList(List<Accessor> accessorList) {
        this.accessorList = accessorList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Designation() {

    }


    public Designation(Integer id, String name) {
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
    public String toString() {
        return name;
    }
}
