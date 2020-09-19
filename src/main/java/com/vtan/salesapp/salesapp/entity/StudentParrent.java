package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;

@Entity
@Table(name="studentparrent")
public class StudentParrent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private RegistedStudent studentId;

    @ManyToOne
    @JoinColumn(name = "parrentId")
    private Parrent parrentId;

    @Column(name = "status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegistedStudent getStudentId() {
        return studentId;
    }

    public void setStudentId(RegistedStudent studentId) {
        this.studentId = studentId;
    }

    public Parrent getParrentId() {
        return parrentId;
    }

    public void setParrentId(Parrent parrentId) {
        this.parrentId = parrentId;
    }

    public StudentParrent(Integer id,RegistedStudent studentId, Parrent parrentId,Boolean status) {
        this.id=id;
        this.studentId = studentId;
        this.parrentId = parrentId;
        this.status=status;
    }

    public StudentParrent() {

    }


}
