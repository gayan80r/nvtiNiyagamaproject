package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private  String name;
   /* @OneToMany( mappedBy = "empstatudid")
    private List<EmployeeLeave> employeeLeaveList;*/
}
