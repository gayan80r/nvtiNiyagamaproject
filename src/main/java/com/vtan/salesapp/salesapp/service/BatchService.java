package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;

import java.util.List;

public interface BatchService {
    public void save (Batch b);
    public void update (Batch b);
    public void delete (Batch b);
    public List<Batch> findAll();
    public Batch findByName(String name);

    public Batch findById(int id);
    public List<Batch> findByStatus(int status);
    public List<Batch> findByStatusAndyearId(int status,int yearid);
    public List<Batch> findByYearAndCourseId(int yearid,int corseid);
    //public List<Batch> findByStatusAndStudentId(int status,int yearid);
    //public List<RegistedStudent> findByStatus(int status);

}
