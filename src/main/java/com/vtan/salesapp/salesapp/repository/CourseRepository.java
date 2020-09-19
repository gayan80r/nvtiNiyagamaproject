package com.vtan.salesapp.salesapp.repository;
import com.vtan.salesapp.salesapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer>,CourseCustomRepository {
}
