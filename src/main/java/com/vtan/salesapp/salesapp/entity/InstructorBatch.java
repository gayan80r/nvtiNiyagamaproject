package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="instructorbatch")
public class InstructorBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dateassign")
    @NotNull(message = "Please enter the assign date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateassign;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employee employeid;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batchid;

    public Integer getId() {
        return id;
    }

    public void setEmployeid(Employee employeid) {
        this.employeid = employeid;
    }

    public void setBatchid(Batch batchid) {
        this.batchid = batchid;
    }

    public void setDateassign(Date dateassign) {
        this.dateassign = dateassign;
    }

    public Date getDateassign() {
        return dateassign;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public Employee getEmployeid() {
        return employeid;
    }

    public Batch getBatchid() {
        return batchid;
    }

    public InstructorBatch(Integer id, Date dateassign, boolean status, Employee employeid, Batch batchid) {
        this.id = id;
        this.dateassign = dateassign;
        this.status = status;
        this.employeid = employeid;
        this.batchid = batchid;
    }


    public InstructorBatch() {

    }

    /*@Override
    public String toString() {
        return "id";

    }*/
}
