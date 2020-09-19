package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="gsDivition")
public class GSDivition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private  Integer id;
    @Column(name="name")
    private  String name;

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

    public GSDivition(Integer id,String name) {
        this.id=id;
        this.name = name;
    }
    public GSDivition() {

    }
    @Override
    public String toString() {
        return name;
    }

    @OneToMany(mappedBy = "GSDevision_Id")
    private List<RegistedStudent> registedStudentList;
}
