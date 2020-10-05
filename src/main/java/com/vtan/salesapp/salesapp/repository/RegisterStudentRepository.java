package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterStudentRepository extends JpaRepository<RegistedStudent,Integer> {
    public RegistedStudent findByemail(String email);
    public RegistedStudent findByNic(String nic);
    public List<RegistedStudent> findByStatus(int status);
}
