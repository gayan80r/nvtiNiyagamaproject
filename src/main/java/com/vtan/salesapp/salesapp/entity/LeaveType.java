package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="leavetype")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;

    @Column(name="name")
    private  String name;

    @OneToMany( mappedBy = "empleavetypeid")
    private List<EmployeeLeave> employeeLeaveList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeLeave> getEmployeeLeaveList() {
        return employeeLeaveList;
    }

    public void setEmployeeLeaveList(List<EmployeeLeave> employeeLeaveList) {
        this.employeeLeaveList = employeeLeaveList;
    }

    public LeaveType(Integer id, String name, List<EmployeeLeave> employeeLeaveList) {
        this.id = id;
        this.name = name;
        this.employeeLeaveList = employeeLeaveList;
    }
    public LeaveType() {

    }

    @Override
    public String toString() {
        return "name";
    }
}
