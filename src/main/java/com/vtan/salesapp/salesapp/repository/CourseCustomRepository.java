package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Course;

import java.util.List;


public interface CourseCustomRepository {
    public Course findByName(String name);
    public List<Course> findByStatus(boolean status);
}
