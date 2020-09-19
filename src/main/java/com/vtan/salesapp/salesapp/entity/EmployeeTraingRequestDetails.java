package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="employeetrainingrequestdetails")
public class EmployeeTraingRequestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "daterequest")
    @NotNull(message = "Please enter the Date of Date complete !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datecomplete;

    @Column(name = "status")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Last Name should have minimum 3 letters!")
    private String status;

    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee empid;

    @ManyToOne
    @JoinColumn(name = "employeetrainingid")
    private EmployeeTraining emptraid;

}
