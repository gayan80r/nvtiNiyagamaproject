package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;

@Entity
@Table(name="coursesemister")
public class CourseSemister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course courseId;

    @ManyToOne
    @JoinColumn(name = "semisterid")
    private Semister semisterId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Semister getSemisterId() {
        return semisterId;
    }

    public void setSemisterId(Semister semisterId) {
        this.semisterId = semisterId;
    }

    public CourseSemister(Integer id, Course courseId, Semister semisterId) {
        this.id = id;
        this.courseId = courseId;
        this.semisterId = semisterId;
    }

    public CourseSemister() {
    }
}
