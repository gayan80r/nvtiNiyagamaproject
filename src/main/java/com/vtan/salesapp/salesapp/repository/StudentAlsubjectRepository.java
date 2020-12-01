package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.StudentAlsubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAlsubjectRepository extends JpaRepository<StudentAlsubject,Integer> {
   // public StudentAlsubject findByName(String name);
    //public List<StudentAlsubject> findByStatus(int status);
}
