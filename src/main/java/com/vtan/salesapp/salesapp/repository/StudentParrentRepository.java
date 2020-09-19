package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.StudentParrent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentParrentRepository extends JpaRepository<StudentParrent,Integer>,StudentParrentCustomeRepository {
}
