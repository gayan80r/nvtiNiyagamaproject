package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.repository.EmployeeCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
// we used the multiple inheritance
public interface EmployeeRepository extends JpaRepository<Employee,Integer>, EmployeeCustomRepository {

}
