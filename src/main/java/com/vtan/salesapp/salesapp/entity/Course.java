package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "Name  minimum 3 letters!")
    @NotEmpty(message = "")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "")
    @Column(name = "description")
    @Size(min = 3, message = "Description  minimum 3 letters!")
    private String description;

    @Column(name = "status")
    private boolean status;

    /*public Course(List<Module> moduleList) {
        this.moduleList = moduleList;
    }*/

    @OneToMany(mappedBy = "courseId")
    private List<Module> moduleList;

    public List<Module> getModuleList() {
        return moduleList;
    }
    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Course(Integer id, String name, String description, boolean status, Trade tradeId, CourseType coursetypeId, CourseDuration coursedurationId, NvqLevel nvqlevelId,List<Module> moduleList) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.tradeId = tradeId;
        this.coursetypeId = coursetypeId;
        this.coursedurationId = coursedurationId;
        this.nvqlevelId = nvqlevelId;
        this.moduleList = moduleList;
    }



    public CourseType getCoursetypeId() {
        return coursetypeId;
    }

    public void setCoursetypeId(CourseType coursetypeId) {
        this.coursetypeId = coursetypeId;
    }

    public NvqLevel getNvqlevelId() {
        return nvqlevelId;
    }

    public void setNvqlevelId(NvqLevel nvqlevelId) {
        this.nvqlevelId = nvqlevelId;
    }

    @ManyToOne
    @JoinColumn(name = "tradeId")
    private Trade tradeId;

    @ManyToOne
    @JoinColumn(name = "coursetypeId")
    private CourseType coursetypeId;

    @ManyToOne
    @JoinColumn(name = "coursedurationId")
    private CourseDuration coursedurationId;

    @ManyToOne
    @JoinColumn(name = "nvqlevelId")
    private NvqLevel nvqlevelId;

    public CourseDuration getCoursedurationId() {
        return coursedurationId;
    }

    public void setCoursedurationId(CourseDuration coursedurationId) {
        this.coursedurationId = coursedurationId;
    }

    public Integer getId() {
        return id;
    }

    @OneToMany(mappedBy = "courseid")
    private List<Batch> batchList;

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    public Course() {

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





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trade getTradeId() {
        return tradeId;
    }

    public void setTradeId(Trade tradeId) {
        this.tradeId = tradeId;
    }

    @Override
    public String toString() {
        return name;
    }
}
