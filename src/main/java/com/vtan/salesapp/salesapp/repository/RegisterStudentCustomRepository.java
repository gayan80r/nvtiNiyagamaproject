package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.RegistedStudent;

import java.util.List;

public interface RegisterStudentCustomRepository {
    public RegistedStudent findByemail(String email);
    public RegistedStudent findByNic(String nic);
    public List<RegistedStudent> findByStatus(boolean status);
    //public RegistedStudent findByNameWithInitial(String namewithinitial);

}
