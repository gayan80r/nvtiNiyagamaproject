
package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
}