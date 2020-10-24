package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;

@Entity
@Table(name="systemuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="username")
    private  String username;
    @Column(name="password")
    private  String password;
    @ManyToOne
    @JoinColumn (name="employee_id")
    private Employee employee;
    @ManyToOne
    //many user have one role

    @JoinColumn(name="role_id")
    private Role role;

   // private Transient String confirmPassword;



    //user have only one role
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(){


 }



}
