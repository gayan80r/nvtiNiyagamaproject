package com.vtan.salesapp.salesapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
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

    public String getEpf_no() {
        return epf_no;
    }

    public void setEpf_no(String epf_no) {
        this.epf_no = epf_no;
    }

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


    @Column(name = "dob")
    @NotNull(message = "Please enter the Date of Birth !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;




    @Column(name = "address_line1")
    private String address_line1;
    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "city")
    private String city;
    @Column(name = "image")
    private byte[] image;


    @Column(name = "status")
    private boolean status;
    //same gender available for many employee we think on the employee side not gender
    //therefore we used the @ManyToOne
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender genderId;


    @ManyToOne
    @JoinColumn(name = "desination_id")
    private Designation designationId;

    public Designation getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Designation designationId) {
        this.designationId = designationId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentId;

    public CivilStatus getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(CivilStatus civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "CivilStatus_Id")
    private CivilStatus civilStatusId;

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

    @ManyToOne
    @JoinColumn(name = "highset_educational_qualification_id")
    private highestEducationalQualification highset_educational_qualification_id;

    @ManyToOne
    @JoinColumn(name = "highset_vocational_qualification_id")
    private highestVocationalQualification highset_vocational_qualification_id;


    @OneToMany(mappedBy = "empid")
    private List<EmployeeTrainingDetails> employeeTriningDetailsList;

    @OneToMany(mappedBy = "empid")
    private List<EmployeeTraingRequestDetails> employeeTraingRequestDetails;

    public List<EmployeeTraingRequestDetails> getEmployeeTraingRequestDetails() {
        return employeeTraingRequestDetails;
    }

    public void setEmployeeTraingRequestDetails(List<EmployeeTraingRequestDetails> employeeTraingRequestDetails) {
        this.employeeTraingRequestDetails = employeeTraingRequestDetails;
    }
    /*public Employee(List<EmployeeTriningDetails> employeeTriningDetailsList) {
        this.employeeTriningDetailsList = employeeTriningDetailsList;
    }*/

    public List<EmployeeTrainingDetails> getEmployeeTriningDetailsList() {
        return employeeTriningDetailsList;
    }

    public void setEmployeeTriningDetailsList(List<EmployeeTrainingDetails> employeeTriningDetailsList) {
        this.employeeTriningDetailsList = employeeTriningDetailsList;
    }

    public Department getDepartmentId() {
        return departmentId;
    }


    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }


    public Employee(int id,String first_name, String last_name, String mobile, String home, String email, Date dob, String address_line1, String address_line2, String city, byte[] image, boolean status, Gender genderId, Designation designationId, Department departmentId, CivilStatus civilStatusId, highestEducationalQualification highset_educational_qualification_id, highestVocationalQualification highset_vocational_qualification_id,List<EmployeeTrainingDetails> employeeTriningDetailsList,List<InstructorBatch> instructorBatchList) {
        this.id=id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nic = nic;
        this.epf_no = epf_no;
        this.mobile = mobile;
        this.home = home;
        this.email = email;
        this.dob = dob;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.image = image;
        this.status = status;
        this.genderId = genderId;
        this.designationId = designationId;
        this.departmentId = departmentId;
        this.civilStatusId = civilStatusId;
        this.highset_educational_qualification_id = highset_educational_qualification_id;
        this.highset_vocational_qualification_id = highset_vocational_qualification_id;
       // this.employeeTrainingDetailsList = employeeTrainingDetailsList;
        this.employeeTriningDetailsList=employeeTriningDetailsList;
        //this.employeeLeaveList=employeeLeaveList;

    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<InstructorBatch> getInstructorBatchList() {
        return instructorBatchList;
    }

    public void setInstructorBatchList(List<InstructorBatch> instructorBatchList) {
        this.instructorBatchList = instructorBatchList;
    }


    public Employee() {
    }

    @OneToMany(mappedBy = "employeid")
    private List<InstructorBatch> instructorBatchList;


    /*@OneToMany(mappedBy = "empleavetypeid")
    private List<EmployeeLeave> employeeLeaveList;

    public List<EmployeeLeave> getEmployeeLeaveList() {
        return employeeLeaveList;
    }

    public void setEmployeeLeaveList(List<EmployeeLeave> employeeLeaveList) {
        this.employeeLeaveList = employeeLeaveList;
    }*/

    public Employee(Integer id, String first_name, String last_name, String nic, String mobile, String home, Date dob, String address_line1, String address_line2, String city, byte[] image, List<InstructorBatch> instructorBatchList) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nic = nic;
        this.mobile = mobile;
        this.home = home;
        this.dob = dob;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.image = image;

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

    @Override
    public String toString() {
        return first_name + " " + last_name;
    }

    public String getName_with_initial() {
        return name_with_initial;
    }

    public void setName_with_initial(String name_with_initial) {
        this.name_with_initial = name_with_initial;
    }
}
