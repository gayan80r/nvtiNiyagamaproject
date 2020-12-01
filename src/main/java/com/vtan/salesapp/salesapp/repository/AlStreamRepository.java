package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.AlStream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlStreamRepository extends JpaRepository<AlStream,Integer> {
    public AlStream findByName(String name);
    //public List<AlStream> findByStatus(int status);
}
