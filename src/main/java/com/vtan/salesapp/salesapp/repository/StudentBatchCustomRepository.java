package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentBatch;

import java.util.List;

public interface StudentBatchCustomRepository {
    public List<StudentBatch> findByStatus(boolean status);

    public List<StudentBatch> finByStundentBatchId(Batch batchid, RegistedStudent studentid);
}
