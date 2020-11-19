package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface StudentBatchCustomRepository {
    public List<StudentBatch> findByStatus(boolean status);

    public List<StudentBatch> finByStundentBatchId(Batch batchid, RegistedStudent studentid);
    public List<StudentBatchCourse> finByStundentBatchIdCourseId(Batch batchid, Course courseId);
    public List<StudentBatch> findByBatch(Year yearid);
    public List<StudentBatch> finByStundent(Batch batchid);
}
