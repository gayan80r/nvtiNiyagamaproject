package com.vtan.salesapp.salesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee1 implements Serializable {
    @Id //use to configure primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use to configure auto increment constrains
    @Column(name = "id")// use to configure the bellow variable
    private Integer id;

    @Column(name = "fullname")
    @NotEmpty(message = "")
    @Size(min = 3, message = "First Name should have minimum 3 letters!")
    private String full_name;

    @Column(name = "name_with_initial")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Name with initial should have minimum 3 letters!")
    private String name_with_initial;

    @Column(name = "nic")
    @NotEmpty(message = "")
    @Pattern(regexp = "([0-9]{9}[V|v|x|X])|([0-9]{12})", message = "Please enter a Valid NIC!")
    private String nic;

    @Column(name = "epf_no")
    @NotEmpty(message = "")
    @Size(min = 4, message = "EPF No should have minimum 4 letters!")
    private String epf_no;

    @Column(name = "mobile")
    @NotEmpty(message = "")
    @Pattern(regexp = "^(\\d{3}[- .]?){2}\\d{4}$", message = "Please enter a Valid Mobile Number!")
    private String mobile;

    @Column(name = "home")
    private String home;

    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Please enter a Valid Email Address")
    private String email;


    @Column(name = "dob")
    @NotNull(message = "Please enter the Date of Birth !")
    @DateTimeFormat(pattern = "MMMM dd, yyyy")
    private Date dob;

    @Column(name = "address_line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "image")
    private byte[] image;


    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "gender_id")
    private Gender gender_id;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employee_type_id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "desination_id")
    private Designation desination_id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city_id;

    @ManyToOne
    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "department_id")
    private Department department_id;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "CivilStatus_Id")
    private CivilStatus civil_status_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "highset_educational_qualification_id")
    private highestEducationalQualification highset_educational_qualification_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "highset_vocational_qualification_id")
    private highestVocationalQualification highset_vocational_qualification_id;


    @OneToMany(mappedBy = "empid")
    private List<EmployeeTrainingDetails> employeeTriningDetailsList;

    @OneToMany(mappedBy = "empid")
    private List<EmployeeTraingRequestDetails> employeeTraingRequestDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "employeid")
    private List<InstructorBatch> instructorBatchList;

    public Employee1() {
    }

    public Employee1(Integer id, @NotEmpty(message = "") @Size(min = 3, message = "First Name should have minimum 3 letters!") String full_name, @NotEmpty(message = "") @Size(min = 3, message = "Name with initial should have minimum 3 letters!") String name_with_initial, @NotEmpty(message = "") @Pattern(regexp = "([0-9]{9}[V|v|x|X])|([0-9]{12})", message = "Please enter a Valid NIC!") String nic, @NotEmpty(message = "") @Size(min = 4, message = "EPF No should have minimum 4 letters!") String epf_no, @NotEmpty(message = "") @Pattern(regexp = "^(\\d{3}[- .]?){2}\\d{4}$", message = "Please enter a Valid Mobile Number!") String mobile, String home, @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Please enter a Valid Email Address") String email, @NotNull(message = "Please enter the Date of Birth !") Date dob, String address_line1, String address_line2, byte[] image, boolean status, Gender gender_id, EmployeeType employee_type_id, Designation desination_id, City city_id, Department department_id, CivilStatus civil_status_id, highestEducationalQualification highset_educational_qualification_id, highestVocationalQualification highset_vocational_qualification_id) {
        this.id = id;
        this.full_name = full_name;
        this.name_with_initial = name_with_initial;
        this.nic = nic;
        this.epf_no = epf_no;
        this.mobile = mobile;
        this.home = home;
        this.email = email;
        this.dob = dob;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.image = image;
        this.status = status;
        this.gender_id = gender_id;
        this.employee_type_id = employee_type_id;
        this.desination_id = desination_id;
        this.city_id = city_id;
        this.department_id = department_id;
        this.civil_status_id = civil_status_id;
        this.highset_educational_qualification_id = highset_educational_qualification_id;
        this.highset_vocational_qualification_id = highset_vocational_qualification_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public String getEpf_no() {
        return epf_no;
    }

    public void setEpf_no(String epf_no) {
        this.epf_no = epf_no;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Gender getGender_id() {
        return gender_id;
    }

    public void setGender_id(Gender gender_id) {
        this.gender_id = gender_id;
    }

    public EmployeeType getEmployee_type_id() {
        return employee_type_id;
    }

    public void setEmployee_type_id(EmployeeType employee_type_id) {
        this.employee_type_id = employee_type_id;
    }

    public Designation getDesination_id() {
        return desination_id;
    }

    public void setDesination_id(Designation desination_id) {
        this.desination_id = desination_id;
    }

    public City getCity_id() {
        return city_id;
    }

    public void setCity_id(City city_id) {
        this.city_id = city_id;
    }

    public Department getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Department department_id) {
        this.department_id = department_id;
    }

    public CivilStatus getCivil_status_id() {
        return civil_status_id;
    }

    public void setCivil_status_id(CivilStatus civil_status_id) {
        this.civil_status_id = civil_status_id;
    }

    public highestEducationalQualification getHighset_educational_qualification_id() {
        return highset_educational_qualification_id;
    }

    public void setHighset_educational_qualification_id(highestEducationalQualification highset_educational_qualification_id) {
        this.highset_educational_qualification_id = highset_educational_qualification_id;
    }

    public highestVocationalQualification getHighset_vocational_qualification_id() {
        return highset_vocational_qualification_id;
    }

    public void setHighset_vocational_qualification_id(highestVocationalQualification highset_vocational_qualification_id) {
        this.highset_vocational_qualification_id = highset_vocational_qualification_id;
    }

    public List<EmployeeTrainingDetails> getEmployeeTriningDetailsList() {
        return employeeTriningDetailsList;
    }

    public void setEmployeeTriningDetailsList(List<EmployeeTrainingDetails> employeeTriningDetailsList) {
        this.employeeTriningDetailsList = employeeTriningDetailsList;
    }

    public List<EmployeeTraingRequestDetails> getEmployeeTraingRequestDetails() {
        return employeeTraingRequestDetails;
    }

    public void setEmployeeTraingRequestDetails(List<EmployeeTraingRequestDetails> employeeTraingRequestDetails) {
        this.employeeTraingRequestDetails = employeeTraingRequestDetails;
    }

    public List<InstructorBatch> getInstructorBatchList() {
        return instructorBatchList;
    }

    public void setInstructorBatchList(List<InstructorBatch> instructorBatchList) {
        this.instructorBatchList = instructorBatchList;
    }
}
