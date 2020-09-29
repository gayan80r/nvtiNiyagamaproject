package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
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

    /*@Column(name="namewithinitial")
    @NotNull(message = "Please enter the Name with initial")
    private  String namewithinitial;*/

    @Column(name = "startdate")
    @NotNull(message = "Please enter the Leave  Start Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Time startdate;
    @Column(name = "enddate")
    @NotNull(message = "Please enter the Leave  End Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //private Date enddate;
    private Time enddate;

    @Column(name = "applydate")
    @NotNull(message = "Please enter the Apply Date !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applydate;

    /*@ManyToOne
    @JoinColumn(name="manager_id")
    private Employee manager;*/
    @Column(name = "status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Column(name="coveringEmployee")
    @NotNull(message = "Please enter the covering Employee name")
    private  String coveringEmployeeId;

    @Column(name="approvedEmployee")
    @NotNull(message = "Please enter the approved Employee name")
    private  String approvedEmployeeId;

    public String getEpf_no() {
        return epf_no;
    }

    public void setEpf_no(String epf_no) {
        this.epf_no = epf_no;
    }

   /* public String getNamewithinitial() {
        return namewithinitial;
    }

    public void setNamewithinitial(String namewithinitial) {
        this.namewithinitial = namewithinitial;
    }*/

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getCoveringEmployee() {
        return coveringEmployeeId;
    }

    public void setCoveringEmployee(String coveringEmployee) {
        this.coveringEmployeeId = coveringEmployeeId;
    }

    public String getApprovedEmployee() {
        return coveringEmployeeId;
    }

    public void setApprovedEmployee(String approvedEmployee) {
        this.coveringEmployeeId = coveringEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "empid")
    private Employee employeeid;

    /*@ManyToOne
    @JoinColumn(name = "empoyeestatusid")
    private Status empstatudid;*/

   /* public Status getEmpstatudid() {
        return empstatudid;
    }

    public void setEmpstatudid(Status empstatudid) {
        this.empstatudid = empstatudid;
    }*/

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

    public String getCoveringEmployeeId() {
        return coveringEmployeeId;
    }

    public void setCoveringEmployeeId(String coveringEmployeeId) {
        this.coveringEmployeeId = coveringEmployeeId;
    }

    public String getApprovedEmployeeId() {
        return approvedEmployeeId;
    }

    public void setApprovedEmployeeId(String approvedEmployeeId) {
        this.approvedEmployeeId = approvedEmployeeId;
    }

   /* public Date getStartdate() {
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
    }*/

    public Time getStartdate() {
        return startdate;
    }

    public void setStartdate(Time startdate) {
        this.startdate = startdate;
    }

    public Time getEnddate() {
        return enddate;
    }

    public void setEnddate(Time enddate) {
        this.enddate = enddate;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public EmployeeLeave(Integer id,String epf_no,  Time startdate,  Time enddate,Date applydate,String coveringEmployee,String approvedEmployee,LeaveType empleavetypeid, Employee employeeid,boolean status) {
        this.id = id;
       this.epf_no=epf_no;
       // this.namewithinitial = namewithinitial;
        this.startdate = startdate;
        this.enddate = enddate;
        this.applydate=applydate;
        this.coveringEmployeeId=coveringEmployeeId;
        this.approvedEmployeeId=approvedEmployeeId;
       // this.empstatudid = empstatudid;
        this.empleavetypeid = empleavetypeid;
        this.employeeid = employeeid;
        this.status=status;

    }

    public EmployeeLeave() {

    }


}
