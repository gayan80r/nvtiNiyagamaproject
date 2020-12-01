package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.AlStreamSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlStreamSubjectRepository extends JpaRepository<AlStreamSubject,Integer> {
    //public AlStreamSubject findByName(String name);
   // public List<AlStreamSubject> findByStatus(int status);
}
