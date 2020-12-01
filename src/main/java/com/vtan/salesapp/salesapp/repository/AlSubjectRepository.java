package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.AlSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlSubjectRepository extends JpaRepository<AlSubject,Integer> {
    public AlSubject findByName(String name);
    //public List<AlSubject> findByStatus(int status);
}
