package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="employeeleave")
public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;

    @Column(name = "epf_no")
    @NotEmpty(message = "")
    @Size(min = 4, message = "EPF No should have minimum 4 letters!")
    private String epf_no;

    @Column(name="namewithinitial")
    @NotNull(message = "Please enter the Name with initial")
    private  String namewithinitial;

    @Column(name = "startdate")
    @NotNull(message = "Please enter the Leave  Start Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startdate;
    @Column(name = "enddate")
    @NotNull(message = "Please enter the Leave  End Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddate;

    @Column(name = "appydate")
    @NotNull(message = "Please enter the Apply Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applydate;

    @Column(name="coveringEmployee")
    @NotNull(message = "Please enter the covering Employee name")
    private  String coveringEmployee;

    @Column(name="approvedEmployee")
    @NotNull(message = "Please enter the approved Employee name")
    private  String approvedEmployee;

    public String getEpf_no() {
        return epf_no;
    }

    public void setEpf_no(String epf_no) {
        this.epf_no = epf_no;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getCoveringEmployee() {
        return coveringEmployee;
    }

    public void setCoveringEmployee(String coveringEmployee) {
        this.coveringEmployee = coveringEmployee;
    }

    public String getApprovedEmployee() {
        return approvedEmployee;
    }

    public void setApprovedEmployee(String approvedEmployee) {
        this.approvedEmployee = approvedEmployee;
    }

    @ManyToOne
    @JoinColumn(name = "empid")
    private Employee employeeid;

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

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public EmployeeLeave(Integer id,String epf_no, String namewithinitial,  Date startdate,  Date enddate,Date applydate,String coveringEmployee,String approvedEmployee,Status empstatudid,LeaveType empleavetypeid, Employee employeeid) {
        this.id = id;
        this.epf_no=epf_no;
        this.namewithinitial = namewithinitial;
        this.startdate = startdate;
        this.enddate = enddate;
        this.applydate=applydate;
        this.coveringEmployee=coveringEmployee;
        this.approvedEmployee=approvedEmployee;
        this.empstatudid = empstatudid;
        this.empleavetypeid = empleavetypeid;
        this.employeeid = employeeid;

    }

    public EmployeeLeave() {

    }

}
