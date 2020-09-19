package com.vtan.salesapp.salesapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="semister")
public class Semister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "Name  minimum 3 letters!")
    @NotEmpty(message = "")
    @Column(name = "name")
    private String name;

    @OneToMany( mappedBy = "semesterId")
    private List<Module> moduleList;

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

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public Semister(Integer id,  String name, List<Module> moduleList) {
        this.id = id;
        this.name = name;
        this.moduleList = moduleList;
    }

    public Semister() {

    }

    @Override
    public String toString() {
        return name;
    }
}
