package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface StudentBatchService {
    public void save (StudentBatch sb);
    public void update (StudentBatch sb);
    public void delete (StudentBatch sb);
    public StudentBatch  findById(int id);

   public List<StudentBatch > findByStatus(boolean status);
    public List<StudentBatch > findAll();
    public List<StudentBatch>  finByStundentBatchId(Batch batchid, RegistedStudent studentid);
    public List<StudentBatchCourse>  finByStundentBatchIdCourseId(Batch batchid, Course courseId);
    public List<StudentBatch> finByStundent(Batch batchid);
}
