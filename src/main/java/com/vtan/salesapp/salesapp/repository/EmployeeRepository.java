package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Employee;
//import com.vtan.salesapp.salesapp.repository.EmployeeCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// we used the multiple inheritance
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Employee findByEmail(String email);
    public Employee findByNic(String nic);
    public List<Employee> findByStatus(boolean status);
}
