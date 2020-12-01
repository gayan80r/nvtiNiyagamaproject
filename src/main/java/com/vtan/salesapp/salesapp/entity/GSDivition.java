package com.vtan.salesapp.salesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public GSDivition(Integer id,String name,List<RegistedStudent> studentList,DevitionalSecatary divitionalId ) {
        this.id=id;
        this.name = name;
        this.divitionalId=divitionalId;
        this.registedStudentList=studentList;
    }
    public GSDivition() {

    }

    public DevitionalSecatary getDivitionalId() {
        return divitionalId;
    }

    public void setDivitionalId(DevitionalSecatary divitionalId) {
        this.divitionalId = divitionalId;
    }

    @Override
    public String toString() {
        return name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "GSDevision_Id")
    private List<RegistedStudent> registedStudentList;

    @ManyToOne
    @JoinColumn(name = "divitional_id")
    private DevitionalSecatary divitionalId;


}
