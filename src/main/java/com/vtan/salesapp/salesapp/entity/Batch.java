package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "Name  minimum 3 letters!")
    @NotEmpty(message = "")
    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    @NotNull(message = "Please enter the Date of Birth !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_date;

    @Column(name = "end_date")
    @NotNull(message = "Please enter the Date of Birth !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_date;

    @Column(name = "status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<StudentBatch> getStudentBatchList() {
        return studentBatchList;
    }

    public void setStudentBatchList(List<StudentBatch> studentBatchList) {
        this.studentBatchList = studentBatchList;
    }

    @OneToMany(mappedBy = "batchid")
    private List<StudentBatch> studentBatchList;

    public List<InstructorBatch> getInstructorBatchList() {
        return instructorBatchList;
    }

   /* public void setInstructorBatchList(List<InstructorBatch> instructorBatchList) {
        this.instructorBatchList = instructorBatchList;
    }*/

    @OneToMany(mappedBy = "batchid")
    private List<InstructorBatch> instructorBatchList;

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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

   /* public Batch getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(Batch course_Id) {
        this.course_Id = course_Id;
    }*/

    public Course getCourse_Id() {
        return courseid;
    }

    public void setCourse_Id(Course course_Id) {
        this.courseid = courseid;
    }

   /* public List<RegistedStudent> getRegistedStudentList() {
        return registedStudentList;
    }

    public void setRegistedStudentList(List<RegistedStudent> registedStudentList) {
        this.registedStudentList = registedStudentList;
    }*/

    public Batch(List<StudentBatch> studentBatchList) {
        this.studentBatchList = studentBatchList;
    }

    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course courseid;

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }
/* @OneToMany(mappedBy = "batch_Id")
    private List<RegistedStudent> registedStudentList;*/

    public Batch(Integer id, String name, Date start_date, Date end_date, Course courseid,List<StudentBatch> studentBatchList,Boolean status,List<InstructorBatch> instructorBatchList) {
        this.id=id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.courseid = courseid;
        this.studentBatchList=studentBatchList;
        this.instructorBatchList = instructorBatchList;
    }

    public Batch() {

    }

    @Override
    public String toString() {
        return name;
    }
}
