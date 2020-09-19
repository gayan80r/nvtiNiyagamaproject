package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="accessor")
public class Accessor {
    @Id //use to configure primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use to configure auto increment constrains
    @Column(name = "id")// use to configure the bellow variable
    private Integer id;

    @Column(name = "firstname")
    @NotEmpty(message = "")
    @Size(min = 3, message = "First Name should have minimum 3 letters!")
    private String first_name;

    @Column(name = "last_name")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Last Name should have minimum 3 letters!")
    private String last_name;

    @Column(name = "namewithinitial")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Name with initial should have minimum 3 letters!")
    private String namewithinitial;

    @Column(name = "nic")
    @NotEmpty(message = "")
    @Pattern(regexp = "([0-9]{9}[V|v|x|X])|([0-9]{12})", message = "Please enter a Valid NIC!")
    private String nic;


    @Column(name = "mobile")
    @NotEmpty(message = "")
    @Pattern(regexp = "((07)(0|1|2|5|6|7|8|9)[0-9]{7})", message = "Please enter a Valid Mobile Number!")
    private String mobile;

    @Column(name = "workingphone")
    @Pattern(regexp = "([0-9]{10})", message = "Please enter a Valid land Line Number!")
    private String workingphone;

    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Please enter a Valid Email Address")
    private String email;

    @Column(name = "address_line1")
    private String address_line1;
    @Column(name = "address_line2")
    private String address_line2;

    public String getNamewithinitial() {
        return namewithinitial;
    }

    public void setNamewithinitial(String namewithinitial) {
        this.namewithinitial = namewithinitial;
    }

    @Column(name = "city")
    private String city;
    @Column(name = "image")
    private byte[] image;

    @Column(name = "bankaccountno")
    private String bankaccountno;

    @ManyToOne
    @JoinColumn(name = "genderid")
    private Gender genderid;


    @ManyToOne
    @JoinColumn(name = "desinationid")
    private Designation designationid;

    @Column(name = "status")
    private boolean status;

    public Gender getGenderid() {
        return genderid;
    }

   /* public Accessor(Gender genderid, Designation designationid) {
        this.genderid = genderid;
        this.designationid = designationid;
    }*/

    public void setGenderid(Gender genderid) {
        this.genderid = genderid;
    }

    public Designation getDesignationid() {
        return designationid;
    }

    public void setDesignationid(Designation designationid) {
        this.designationid = designationid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

   /* public String getName_with_initial() {
        return namewithinitial;
    }

    public void setName_with_initial(String name_with_initial) {
        this.namewithinitial = name_with_initial;
    }
*/
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

    public String getWorkingphone() {
        return workingphone;
    }

    public void setWorkingphone(String workingphone) {
        this.workingphone = workingphone;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBankaccountno() {
        return bankaccountno;
    }

    public void setBankaccountno(String bankaccountno) {
        this.bankaccountno = bankaccountno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return namewithinitial;
    }

    public Accessor(String first_name,   String last_name,  String name_with_initial,  String nic, String mobile, String workingphone,  String email, String address_line1, String address_line2, String city, byte[] image, String bankaccountno, boolean status,Gender genderid, Designation designationid) {
        this.id=id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.namewithinitial = namewithinitial;
        this.nic = nic;
        this.mobile = mobile;
        this.workingphone = workingphone;
        this.email = email;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.image = image;
        this.bankaccountno = bankaccountno;
        this.status = status;
        this.genderid = genderid;
        this.designationid = designationid;
    }


    public Accessor( ) {

    }
}

