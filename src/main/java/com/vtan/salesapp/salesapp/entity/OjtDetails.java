package com.vtan.salesapp.salesapp.entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name="ojtdetails")
public class OjtDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "studentid")
    private RegistedStudent  studentid;

    @ManyToOne
    @JoinColumn(name = "ojtid")
    private OJTPlace  ojtid;

    @Column(name = "datejoint")
    @NotNull(message = "Please enter the date joint date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datejoint;


    @Column(name = "completionDate")
    @NotNull(message = "Please enter the completion date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date completionDate;

    @Column(name = "status")
    private boolean status;

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

    public OJTPlace getOjtid() {
        return ojtid;
    }

    public void setOjtid(OJTPlace ojtid) {
        this.ojtid = ojtid;
    }

    public Date getDatejoint() {
        return datejoint;
    }

    public void setDatejoint(Date datejoint) {
        this.datejoint = datejoint;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public OjtDetails(Integer id, RegistedStudent studentid, OJTPlace ojtid, Date datejoint,  Date completionDate, boolean status) {
        this.id = id;
        this.studentid = studentid;
        this.ojtid = ojtid;
        this.datejoint = datejoint;
        this.completionDate = completionDate;
        this.status = status;
    }

    public OjtDetails() {

    }
    /* @Column(name = "Ojtstatus")
    private boolean Ojtstatus;*/
}
