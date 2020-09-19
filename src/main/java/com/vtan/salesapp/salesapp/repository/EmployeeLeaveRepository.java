package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave,Integer>,EmployeeLeaveCustomRepository  {
}
