package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="studentsemistermarks ")
public class StudentSemisterMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "comments")
    @NotEmpty(message = "")
    @Size(min = 3, message = "comments should have minimum 3 letters!")
    private String comments;
    @ManyToOne
    @JoinColumn(name = "registedStudent_id")
    private RegistedStudent registedStudentId;

    @ManyToOne
    @JoinColumn(name = "semisterExamGrade_id")
    private SemisterExamGrade semisterExamGradeId;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module moduleId;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year yearId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public RegistedStudent getRegistedStudentId() {
        return registedStudentId;
    }

    public void setRegistedStudentId(RegistedStudent registedStudentId) {
        this.registedStudentId = registedStudentId;
    }

    public SemisterExamGrade getSemisterExamGradeId() {
        return semisterExamGradeId;
    }

    public void setSemisterExamGradeId(SemisterExamGrade semisterExamGradeId) {
        this.semisterExamGradeId = semisterExamGradeId;
    }

    public Module getModuleId() {
        return moduleId;
    }

    public void setModuleId(Module moduleId) {
        this.moduleId = moduleId;
    }

    public Year getYearId() {
        return yearId;
    }

    public void setYearId(Year yearId) {
        this.yearId = yearId;
    }

    public StudentSemisterMarks( int id, String comments, RegistedStudent registedStudentId, SemisterExamGrade semisterExamGradeId, Module moduleId, Year yearId) {
        this.id=id;
        this.comments = comments;
        this.registedStudentId = registedStudentId;
        this.semisterExamGradeId = semisterExamGradeId;
        this.moduleId = moduleId;
        this.yearId = yearId;
    }

    public StudentSemisterMarks(  ) {

    }


}
