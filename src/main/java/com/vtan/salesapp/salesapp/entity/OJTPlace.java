package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="ojtplace")
public class OJTPlace{
    @Id //use to configure primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use to configure auto increment constrains
    @Column(name = "id")// use to configure the bellow variable
    private Integer id;
    @Column(name = "name")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Contact person should have minimum 3 letters!")
    private String name;
    @Column(name = "contactperson")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Contact person should have minimum 3 letters!")
    private String contactperson;
    @Column(name = "mobile")
    @NotEmpty(message = "")
    @Pattern(regexp = "((07)(0|1|2|5|6|7|8|9)[0-9]{7})", message = "Please enter a Valid Mobile Number!")
    private String mobile;

    @Column(name = "landline")
    @Pattern(regexp = "([0-9]{10})", message = "Please enter a Valid land Line Number!")
    private String landline;

    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Please enter a Valid Email Address")
    private String email;

    @Column(name = "address_line1")
    private String address_line1;
    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "city")
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "status")
    private boolean status;

    public List<OjtDetails> getOjtDetailsList() {
        return ojtDetailsList;
    }

    public void setOjtDetailsList(List<OjtDetails> ojtDetailsList) {
        this.ojtDetailsList = ojtDetailsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @OneToMany(mappedBy = "ojtid")
    private List<OjtDetails> ojtDetailsList;

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
              name;

    }

    public OJTPlace(Integer id,String name, String contactperson,  String mobile,  String landline, String email, String address_line1, String address_line2, String city, boolean status) {
        this.id=id;
        this.name=name;
        this.contactperson = contactperson;
        this.mobile = mobile;
        this.landline = landline;
        this.email = email;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.ojtDetailsList = ojtDetailsList;
        this.city = city;
        this.status = status;
    }

    public OJTPlace( ) {

    }


}
