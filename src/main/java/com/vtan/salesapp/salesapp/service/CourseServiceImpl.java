package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void save(Course co) {
        courseRepository.save(co);
    }

    @Override
    public void update(Course co) {
        courseRepository.save(co);
    }

    @Override
    public void delete(Course co) {
        courseRepository.delete(co);
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id).get();

    }

    @Override
    public Course findByName(String name) {
       return courseRepository.findByName(name);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByStatus(boolean status) {
        return courseRepository.findByStatus(status);
    }
}
