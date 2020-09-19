package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.InstructorBatch;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import com.vtan.salesapp.salesapp.repository.InstructorBatchRepository;
import com.vtan.salesapp.salesapp.repository.StudentParrentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorBatchServiceImpl implements InstructorBatchService{
    @Autowired
    private InstructorBatchRepository instructorBatchRepository;
    @Override
    public void save(InstructorBatch ib) {
        instructorBatchRepository.save(ib);
    }

    @Override
    public void update(InstructorBatch ib) {
        instructorBatchRepository.save(ib);
    }

    @Override
    public void delete(InstructorBatch ib) {
        instructorBatchRepository.delete(ib);
    }

    @Override
    public InstructorBatch findById(int id) {
        //return null;
     return    instructorBatchRepository.findById(id).get();
    }

    @Override
    public List<InstructorBatch> findByStatus(boolean status) {
        return instructorBatchRepository.findByStatus(status);
    }







    @Override
    public List<InstructorBatch> findAll() {
        return instructorBatchRepository.findAll();
    }

    @Override
    public List<InstructorBatch> finByInstructortBatchId(Batch batchid, Employee empid) {
        return instructorBatchRepository.finByInstructorBatchId(batchid,empid);
    }


}
