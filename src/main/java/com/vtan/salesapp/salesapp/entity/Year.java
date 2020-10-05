package com.vtan.salesapp.salesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="year ")
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private  String name;
    @JsonIgnore
    @OneToMany(mappedBy = "yearId")
    private List<StudentSemisterMarks> studentSemisterMarksList;

    public List<StudentSemisterMarks> getStudentSemisterMarksList() {
        return studentSemisterMarksList;
    }

    public void setStudentSemisterMarksList(List<StudentSemisterMarks> studentSemisterMarksList) {
        this.studentSemisterMarksList = studentSemisterMarksList;
    }
    @JsonIgnore
    @OneToMany( mappedBy = "yearId")
    private List<Batch> batchList;
    @JsonIgnore
    @OneToMany( mappedBy = "yearId")
    private List<RegistedStudent> studentList;

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
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

    public Year(int id,String name,List<StudentSemisterMarks> studentSemisterMarksList,List<Batch> batchList) {
        this.id=id;
        this.name = name;
        this.studentSemisterMarksList=studentSemisterMarksList;
        this.batchList = batchList;
    }

    public Year() {

    }


}
