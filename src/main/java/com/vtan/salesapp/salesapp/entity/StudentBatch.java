package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="studentbatch")
public class StudentBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "datejoint")
   @NotNull(message = "Please enter the date joint date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datejoint;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "studentid")
    private RegistedStudent studentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDatejoint() {
        return datejoint;
    }

    public void setDatejoint(Date datejoint) {
        this.datejoint = datejoint;
    }

    public RegistedStudent getStudentid() {
        return studentid;
    }

    public void setStudentid(RegistedStudent studentid) {
        this.studentid = studentid;
    }

    public Batch getBatchid() {
        return batchid;
    }

    public void setBatchid(Batch batchid) {
        this.batchid = batchid;
    }

    @ManyToOne
    @JoinColumn(name = "batchid")
    private Batch batchid;

    public StudentBatch(Integer id  , Date datejoint, boolean status, RegistedStudent studentid, Batch batchid) {
        this.id=id;
        this.datejoint = datejoint;
        this.status = status;
        this.studentid = studentid;
        this.batchid = batchid;
    }

    public StudentBatch() {

    }

}
