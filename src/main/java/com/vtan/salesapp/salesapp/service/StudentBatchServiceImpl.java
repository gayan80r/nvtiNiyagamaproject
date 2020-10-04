package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import com.vtan.salesapp.salesapp.repository.StudentBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentBatchServiceImpl implements StudentBatchService {
    @Autowired
    private StudentBatchRepository studentBatchRepository;
    @Override
    public void save(StudentBatch sb) {
        studentBatchRepository.save(sb);
    }

    @Override
    public void update(StudentBatch sb) {
        studentBatchRepository.save(sb);
    }

    @Override
    public void delete(StudentBatch sb) {
        studentBatchRepository.delete(sb);
    }

    @Override
    public StudentBatch findById(int id) {
        return studentBatchRepository.findById(id).get();
    }

    @Override
    public List<StudentBatch> findByStatus(boolean status) {
        return studentBatchRepository.findByStatus(status);
    }

    @Override
    public List<StudentBatch> findAll() {
        return studentBatchRepository.findAll();
    }

    @Override
    public List<StudentBatch> finByStundentBatchId(Batch batchid, RegistedStudent studentid) {
        //return studentBatchRepository.finByStundBatchId(batchid,studentid);
        return studentBatchRepository.finByStundentBatchId(batchid,studentid);
    }

    @Override
    public List<StudentBatch> finByStundent(Batch batchid) {
        return studentBatchRepository.finByStundent(batchid);
    }
}
