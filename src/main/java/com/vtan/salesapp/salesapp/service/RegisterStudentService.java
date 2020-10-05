package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.RegistedStudent;

import java.util.List;

public interface RegisterStudentService {
    public void save (RegistedStudent rs);
    public void update (RegistedStudent rs);
    public void delete (RegistedStudent rs);

    public RegistedStudent  findById(int id);
    public RegistedStudent findByNic(String nic);
    public RegistedStudent findByemail(String email);

    public List<RegistedStudent > findAll();
    public List<RegistedStudent> findByStatus(int status);
}
