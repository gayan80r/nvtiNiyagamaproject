package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="devitionalSecatary")
public class DevitionalSecatary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private  Integer id;
    @Column(name="name")
    private  String name;

    public DevitionalSecatary(Integer id,String name) {
        this.id=id;
        this.name = name;
    }

    public DevitionalSecatary() {

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

    public List<RegistedStudent> getRegistedStudentList() {
        return registedStudentList;
    }

    public void setRegistedStudentList(List<RegistedStudent> registedStudentList) {
        this.registedStudentList = registedStudentList;
    }

    @Override
    public String toString() {
        return name;
    }

    @OneToMany(mappedBy = "DevisionalSecatary_Id")
    private List<RegistedStudent> registedStudentList;
}
