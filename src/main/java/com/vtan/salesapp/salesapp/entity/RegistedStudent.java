package com.vtan.salesapp.salesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "registedstudent")
public class RegistedStudent {
    @Id //use to configure primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use to configure auto increment constrains
    @Column(name = "id")// use to configure the bellow variable
    private Integer id;

    @Column(name = "firstname")
    @NotEmpty(message = "")
    @Size(min = 3, message = "First Name should have minimum 3 letters!")
    private String first_name;

    @Column(name = "lastname")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Last Name should have minimum 3 letters!")
    private String last_name;

    @Column(name = "name_with_initial")
    @NotEmpty(message = "")
    @Size(min = 3, message = "Name with initial should have minimum 3 letters!")
    private String name;

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


    @Column(name = "dob")
    @NotNull(message = "Please enter the Date of Birth !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Column(name = "address_line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

   /* @Column(name = "city")
    private String city;*/

    @Column(name = "image")
    private byte[] image;

   /* @Column(name = "Register_Year")
    @NotEmpty(message = "")
    private String Register_Year;*/



    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender genderId;

    @ManyToOne
    @JoinColumn(name = "CivilStatus_Id")
    private CivilStatus civilStatusId;

   /* public int getStatus() {
        return status;
    }*/

    public int getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "GSDevision_Id")
    private GSDivition GSDevision_Id;

    @ManyToOne
    @JoinColumn(name = "DevisionalSecatary_Id")
    private DevitionalSecatary DevisionalSecatary_Id;


    @JsonIgnore
    @OneToMany(mappedBy = "studentId")
    private List<StudentParrent> studentParrentList;


    @JsonIgnore
    @OneToMany(mappedBy = "studentid")
    private List<StudentBatch> studentBatchList;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year yearId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public Year getYearId() {
        return yearId;
    }

    public void setYearId(Year yearId) {
        this.yearId = yearId;
    }

    public List<OjtDetails> getOjtDetailsList() {
        return ojtDetailsList;
    }

    public void setOjtDetailsList(List<OjtDetails> ojtDetailsList) {
        this.ojtDetailsList = ojtDetailsList;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "studentid")
    private List<OjtDetails> ojtDetailsList;

    @JsonIgnore
    @OneToMany(mappedBy = "studentid")
    private List<StudentOlSubject> studentOlSubjectList;

    @JsonIgnore
    @OneToMany(mappedBy = "studentid")
    private List<StudentAlsubject> studentAlsubjectList;

    public List<StudentOlSubject> getStudentOlSubjectList() {
        return studentOlSubjectList;
    }

    public void setStudentOlSubjectList(List<StudentOlSubject> studentOlSubjectList) {
        this.studentOlSubjectList = studentOlSubjectList;
    }

    public List<StudentAlsubject> getStudentAlsubjectList() {
        return studentAlsubjectList;
    }

    public void setStudentAlsubjectList(List<StudentAlsubject> studentAlsubjectList) {
        this.studentAlsubjectList = studentAlsubjectList;
    }

    /* @OneToMany(mappedBy = "studentid")
        private List<OJTPlaceDetails> ojtPlaceDetailsList;


    */
    public List<StudentParrent> getStudentParrentList() {
        return studentParrentList;
    }

    public List<StudentBatch> getStudentBatchList() {
        return studentBatchList;
    }


    /*public RegistedStudent(List<StudentBatch> studentBatchList) {
        this.studentBatchList = studentBatchList;
    }*/

    public void setStudentBatchList(List<StudentBatch> studentBatchList) {
        this.studentBatchList = studentBatchList;
    }

    /*public List<StudentParrent> getStudentParrentList() {
        return studentParrentList;
    }*/

    public RegistedStudent(List<StudentParrent> studentParrentList) {
        this.studentParrentList = studentParrentList;
    }

    public void setStudentParrentList(List<StudentParrent> studentParrentList) {
        this.studentParrentList = studentParrentList;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "registedStudentId")
    private List<StudentSemisterMarks> studentSemisterMarksList;

    public List<StudentSemisterMarks> getStudentSemisterMarksList() {
        return studentSemisterMarksList;
    }

    public void setStudentSemisterMarksList(List<StudentSemisterMarks> studentSemisterMarksList) {
        this.studentSemisterMarksList = studentSemisterMarksList;
    }
    /*@ManyToOne
    @JoinColumn(name = "batch_Id")
    private Batch batch_Id;*/



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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/* public String getName_with_initial() {
        return name_with_initial;
    }

    public void setName_with_initial(String name_with_initial) {
        this.name_with_initial = name_with_initial;
    }*/

   /* public String getRegister_Year() {
        return Register_Year;
    }

    public void setRegister_Year(String register_Year) {
        Register_Year = register_Year;
    }*/

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

    /*public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }*/

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public CivilStatus getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(CivilStatus civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public GSDivition getGSDevision_Id() {
        return GSDevision_Id;
    }

    public void setGSDevision_Id(GSDivition GSDevision_Id) {
        this.GSDevision_Id = GSDevision_Id;
    }

    public DevitionalSecatary getDevisionalSecatary_Id() {
        return DevisionalSecatary_Id;
    }

    public void setDevisionalSecatary_Id(DevitionalSecatary devisionalSecatary_Id) {
        DevisionalSecatary_Id = devisionalSecatary_Id;
    }

    /*public Batch getBatch_Id() {
        return batch_Id;
    }

    public void setBatch_Id(Batch batch_Id) {
        this.batch_Id = batch_Id;
    }*/

    public RegistedStudent( int id,String first_name,  String last_name, String name, String nic, String mobile,  String home,  String email,  Date dob, String address_line1, String address_line2, City cityId, byte[] image, Gender genderId, CivilStatus civilStatusId, GSDivition GSDevision_Id, DevitionalSecatary devisionalSecatary_Id,List<StudentParrent> studentParrentList,List<StudentOlSubject> studentOlSubjectList,List<StudentAlsubject> studentAlsubjectList,List<StudentBatch> studentBatchList,List<StudentSemisterMarks> studentSemisterMarksList,Year yearId,int status){
        this.id=id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.name = name;
        this.nic = nic;
        this.mobile = mobile;
        this.home = home;
        this.email = email;
        this.dob = dob;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.studentOlSubjectList = studentOlSubjectList;
        this.studentAlsubjectList = studentAlsubjectList;
        //this.city = city;
        this.cityId=cityId;
        this.image = image;
        this.genderId = genderId;
        this.civilStatusId = civilStatusId;
        this.GSDevision_Id = GSDevision_Id;
        this.DevisionalSecatary_Id = devisionalSecatary_Id;
        this.studentParrentList = studentParrentList;
        this.studentBatchList=studentBatchList;
        this.ojtDetailsList = ojtDetailsList;
        this.studentSemisterMarksList=studentSemisterMarksList;
        //this.Register_Year = Register_Year;
        this.yearId = yearId;
        this.status=status;


        //this.batch_Id = batch_Id;
    }

    public RegistedStudent( ) {


    }
    @Override
    public String toString() {
        return
                name;

    }
}
