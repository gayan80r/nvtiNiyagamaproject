package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "Name  minimum 3 letters!")
    @NotEmpty(message = "")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "")
    @Column(name = "timeduration")
    @Size(min = 3, message = "Description  minimum 3 letters!")
    private String timeduration;

    public Integer getId() {
        return id;
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

    public String getTimeduration() {
        return timeduration;
    }

    public void setTimeduration(String timeduration) {
        this.timeduration = timeduration;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Module( Integer id,String name,  String timeduration, Course courseId,List<ModuleTask> moduleTaskList,Semister semesterId,List<ModuleUnit> moduleUnitList) {
        this.id=id;
        this.name = name;
        this.timeduration = timeduration;
        this.courseId = courseId;
        this.moduleTaskList = moduleTaskList;
        this.semesterId = semesterId;
        this.moduleUnitList = moduleUnitList;

    }



    public List<ModuleTask> getModuleTaskList() {
        return moduleTaskList;
    }

    public void setModuleTaskList(List<ModuleTask> moduleTaskList) {
        this.moduleTaskList = moduleTaskList;
    }

    public Module( ) {

    }

  /*  public Module(Course semesterId) {
        this.semesterId = semesterId;
    }
*/
    @OneToMany(mappedBy = "moduleId")
     private List <ModuleTask> moduleTaskList;

    @OneToMany(mappedBy = "moduleId")
    private List <ModuleUnit> moduleUnitList;



    public List<ModuleUnit> getModuleUnitList() {
        return moduleUnitList;
    }

    public void setModuleUnitList(List<ModuleUnit> moduleUnitList) {
        this.moduleUnitList = moduleUnitList;
    }

   /* public void setSemesterId(Course semesterId) {
        this.semesterId = semesterId;
    }
*/
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semister semesterId;

    @OneToMany(mappedBy = "moduleId")
    private List<StudentSemisterMarks> studentSemisterMarksList;

    public void setSemesterId(Semister semesterId) {
        this.semesterId = semesterId;
    }

    public Semister getSemesterId() {
        return semesterId;
    }

    @Override
    public String toString() {
        return name;
    }
}
