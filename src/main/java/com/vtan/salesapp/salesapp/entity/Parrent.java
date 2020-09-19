package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "parrent")
public class Parrent {
    @Id //use to configure primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use to configure auto increment constrains
    @Column(name = "id")// use to configure the bellow variable
    private Integer id;
    @Column(name = "name_with_initial")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Name with initial should have minimum 3 letters!")
    private String name_with_initial;
    @Column(name = "nic")
    @NotEmpty(message = "")
    @Pattern(regexp = "([0-9]{9}[V|v|x|X])|([0-9]{12})", message = "Please enter a Valid NIC!")
    private String nic;
    @Column(name = "mobile")
    @NotEmpty(message = "")
    @Pattern(regexp = "((07)(0|1|2|5|6|7|8|9)[0-9]{7})", message = "Please enter a Valid Mobile Number!")
    private String mobile;

    @Column(name = "home")
    @Pattern(regexp = "([0-9]{10})", message = "Please enter a Valid land Line Number!")
    private String home;

    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Please enter a Valid Email Address")
    private String email;
    @Column(name = "address_line1")
    private String address_line1;
    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "city")
    private String city;

    @Column(name = "status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "parrentId")
    private List<StudentParrent> studentParrentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_with_initial() {
        return name_with_initial;
    }

    public void setName_with_initial(String name_with_initial) {
        this.name_with_initial = name_with_initial;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<StudentParrent> getStudentParrentList() {
        return studentParrentList;
    }

    public void setStudentParrentList(List<StudentParrent> studentParrentList) {
        this.studentParrentList = studentParrentList;
    }

    @Override
    public String toString() {
        return
                name_with_initial
                ;
    }

    public Parrent( Integer id,String name_with_initial,  String nic, String mobile,  String home,String email, String address_line1, String address_line2, String city, List<StudentParrent> studentParrentList,Boolean status) {
        this.id=id;
        this.name_with_initial = name_with_initial;
        this.nic = nic;
        this.mobile = mobile;
        this.home = home;
        this.email = email;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.studentParrentList = studentParrentList;

        this.status = status;
    }


    public Parrent( ) {

    }

}
