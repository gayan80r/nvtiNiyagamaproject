package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Course;

import java.util.List;

public interface CourseService {
    public void save (Course co);
    public void update (Course co);
    public void delete (Course co);
    public Course findById(int id);
    public Course findByName(String name);
    public List<Course> findAll();
    public List<Course> findByStatus(int status);
}
