package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.StudentOlSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentOlSubjectRepository extends JpaRepository<StudentOlSubject ,Integer> {
    //public StudentOlSubject findByName(String name);
    //public List<StudentOlSubject> findByStatus(int status);
}
