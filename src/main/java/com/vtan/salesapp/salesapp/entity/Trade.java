package com.vtan.salesapp.salesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Size(min = 3, message = "Name  minimum 3 letters!")
    @NotEmpty(message = "")
    private String name;

    public Integer getId() {
        return id;
    }

    public Trade( Integer id, String name) {
        this.id = id;
        this.name = name;
        //this.courseList = courseList;
    }



    public Trade( ) {

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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "tradeId")
    private List<Course> courseList;


    @Override
    public String toString() {
        return name;
    }
}