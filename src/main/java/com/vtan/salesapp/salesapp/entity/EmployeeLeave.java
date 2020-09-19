package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="employeeleave")
public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="namewithinitial")
    private  String namewithinitial;
    @Column(name = "startdate")
    @NotNull(message = "Please enter the Leave  Start Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startdate;
    @Column(name = "enddate")
    @NotNull(message = "Please enter the Leave  End Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddate;
    @ManyToOne
    @JoinColumn(name = "empid")
    private Department employeeid;

    @ManyToOne
    @JoinColumn(name = "empoyeestatusid")
    private Status empstatudid;

    public Status getEmpstatudid() {
        return empstatudid;
    }

    public void setEmpstatudid(Status empstatudid) {
        this.empstatudid = empstatudid;
    }

    public LeaveType getEmpleavetypeid() {
        return empleavetypeid;
    }

    public void setEmpleavetypeid(LeaveType empleavetypeid) {
        this.empleavetypeid = empleavetypeid;
    }

    @ManyToOne
    @JoinColumn(name = "empoyeesleavetypeid")
    private LeaveType empleavetypeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamewithinitial() {
        return namewithinitial;
    }

    public void setNamewithinitial(String namewithinitial) {
        this.namewithinitial = namewithinitial;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Department getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Department employeeid) {
        this.employeeid = employeeid;
    }

    public EmployeeLeave(Integer id, String namewithinitial,  Date startdate,  Date enddate, Department employeeid) {
        this.id = id;
        this.namewithinitial = namewithinitial;
        this.startdate = startdate;
        this.enddate = enddate;
        this.employeeid = employeeid;
    }

    public EmployeeLeave() {

    }

}
