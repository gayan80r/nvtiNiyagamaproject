package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Accessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessorRepository extends JpaRepository<Accessor,Integer> {
    public Accessor findByemail(String email);
    public Accessor findByNic(String nic);
    public List<Accessor> findByStatus(boolean status);
}
