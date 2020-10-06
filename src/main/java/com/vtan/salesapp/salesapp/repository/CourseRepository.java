package com.vtan.salesapp.salesapp.repository;
import com.vtan.salesapp.salesapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    public Course findByName(String name);
    public List<Course> findByStatus(int status);
}
