package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="semisterexamgrade ")
public class SemisterExamGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Last Name should have minimum 3 letters!")
    private  String name;

    @OneToMany(mappedBy = "semisterExamGradeId")
    private List<StudentSemisterMarks> studentSemisterMarksList;

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

    public List<StudentSemisterMarks> getStudentSemisterMarksList() {
        return studentSemisterMarksList;
    }

    public void setStudentSemisterMarksList(List<StudentSemisterMarks> studentSemisterMarksList) {
        this.studentSemisterMarksList = studentSemisterMarksList;
    }

    public SemisterExamGrade(int id,String name, List<StudentSemisterMarks> studentSemisterMarksList) {
        this.id=id;
        this.name = name;
        this.studentSemisterMarksList = studentSemisterMarksList;
    }

    public SemisterExamGrade() {

    }

    @Override
    public String toString() {
        return "name";
    }
}
