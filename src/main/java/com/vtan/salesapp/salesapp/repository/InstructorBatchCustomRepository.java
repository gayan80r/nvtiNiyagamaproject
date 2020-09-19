package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface InstructorBatchCustomRepository {
    public List<InstructorBatch> findByStatus(boolean status);

    List<InstructorBatch> finByInstructorBatchId(Batch batchid, Employee employeeid);
}
