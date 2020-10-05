package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.repository.RegisterStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RegisterStudentServiceImpl implements RegisterStudentService {
    @Autowired
    private RegisterStudentRepository registerStudentRepository;
    @Override
    public void save(RegistedStudent rs) {
        registerStudentRepository.save(rs);
    }

    @Override
    public void update(RegistedStudent rs) {
        registerStudentRepository.save(rs);
    }

    @Override
    public void delete(RegistedStudent rs) {
        registerStudentRepository.delete(rs);
    }

    @Override
    public RegistedStudent findById(int id) {
        return registerStudentRepository.findById(id).get();
    }

    @Override
    public RegistedStudent findByNic(String nic) {
        return registerStudentRepository.findByNic(nic);
    }

    @Override
    public RegistedStudent findByemail(String email) {
        return registerStudentRepository.findByemail(email);
    }

    @Override
    public List<RegistedStudent> findAll() {
        return registerStudentRepository.findAll();
    }

    @Override
    public List<RegistedStudent> findByStatus(int status) {
        return registerStudentRepository.findByStatus(status);
    }

   /* @Override
    public List<RegistedStudent> findByStatusStudent(int status) {
        return registerStudentRepository.findByStatusStudent(status);
    }*/
}
