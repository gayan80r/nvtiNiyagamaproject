package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface InstructorBatchService {
    public void save (InstructorBatch ib);
    public void update (InstructorBatch ib);
    public void delete (InstructorBatch ib);
    public InstructorBatch  findById(int id);

    public List<InstructorBatch  > findByStatus(boolean status);
    public List<InstructorBatch  > findAll();
    public List<InstructorBatch >  finByInstructortBatchId(Batch batchid, Employee empid);
}
