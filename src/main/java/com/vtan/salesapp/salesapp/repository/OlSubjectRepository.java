package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.AlStream;
import com.vtan.salesapp.salesapp.entity.OlSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OlSubjectRepository extends JpaRepository<OlSubject,Integer> {
    public OlSubject findByName(String name);
}
