package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterStudentRepository extends JpaRepository<RegistedStudent,Integer>,RegisterStudentCustomRepository {
}
