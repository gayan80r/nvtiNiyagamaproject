package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Parrent;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentParrent;
import com.vtan.salesapp.salesapp.repository.StudentParrentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class StudentParrentServiceImpl implements StudentParrentService {
    @Autowired
    private StudentParrentRepository studentParrentRepository;


    @Override
    public void save(StudentParrent sp) {
        studentParrentRepository.save(sp);
    }

    @Override
    public void update(StudentParrent sp) {
     studentParrentRepository.save(sp);
    }

    @Override
    public void delete(StudentParrent sp) {
    studentParrentRepository.delete(sp);
    }

    @Override
    public StudentParrent findById(int id) {
        return studentParrentRepository.findById(id).get();
    }

    @Override
    public List<StudentParrent> findByStatus(boolean status) {
        return studentParrentRepository.findByStatus(status);
    }

    @Override
    public List<StudentParrent> findAll() {
        return studentParrentRepository.findAll();
    }

    @Override
    public List<StudentParrent> finByStundentParrendId(Parrent parrentId, RegistedStudent studentId) {
        return studentParrentRepository.finByStundentParrendId(parrentId, studentId);
    }
}
