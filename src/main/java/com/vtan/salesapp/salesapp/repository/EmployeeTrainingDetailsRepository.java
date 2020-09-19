package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.EmployeeTrainingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTrainingDetailsRepository extends JpaRepository<EmployeeTrainingDetails,Integer> ,EmployeeTrainingDetailsCustomRepository {

}
