package com.vtan.salesapp.salesapp.entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="employeetrainingdetails")
public class EmployeeTrainingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "datecomplete")
    @NotNull(message = "Please enter the Date of Date complete !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datecomplete;

    @Column(name = "status")
    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee empid;

    @ManyToOne
    @JoinColumn(name = "employeetrainingid")
    private EmployeeTraining emptraid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatecomplete() {
        return datecomplete;
    }

    public void setDatecomplete(Date datecomplete) {
        this.datecomplete = datecomplete;
    }

    public Employee getEmpid() {
        return empid;
    }

    public void setEmpid(Employee empid) {
        this.empid = empid;
    }

    public EmployeeTraining getEmptraid() {
        return emptraid;
    }

    public void setEmptraid(EmployeeTraining emptraid) {
        this.emptraid = emptraid;
    }

    public EmployeeTrainingDetails( Date datecomplete, Employee empid, EmployeeTraining emptraid,boolean status) {
        this.id=id;
        this.datecomplete = datecomplete;
        this.empid = empid;
        this.emptraid = emptraid;
    }
    public EmployeeTrainingDetails( ) {

    }

}
