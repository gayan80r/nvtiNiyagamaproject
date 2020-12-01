package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="studentolsubject")
public class StudentOlSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private RegistedStudent studentid;

    @ManyToOne
    @JoinColumn(name = "olsubject_id")
    private OlSubject olSubjectId;

    @NotEmpty(message = "")
    @Column(name = "grade")
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegistedStudent getStudentid() {
        return studentid;
    }

    public void setStudentid(RegistedStudent studentid) {
        this.studentid = studentid;
    }

    public OlSubject getOlSubjectId() {
        return olSubjectId;
    }

    public void setOlSubjectId(OlSubject olSubjectId) {
        this.olSubjectId = olSubjectId;
    }

    public StudentOlSubject(Integer id,RegistedStudent studentid, OlSubject olSubjectId) {
       this.id=id;
        this.studentid = studentid;
        this.olSubjectId = olSubjectId;
    }

    public StudentOlSubject() {

    }


}
