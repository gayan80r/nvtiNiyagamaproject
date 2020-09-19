package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
