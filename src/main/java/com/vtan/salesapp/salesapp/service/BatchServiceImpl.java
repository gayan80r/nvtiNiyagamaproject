package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private  YearService yearService;
    @Autowired
    private RegisterStudentService registerStudentService;
    @Override
    public void save(Batch b) {
        batchRepository.save(b);
    }

    @Override
    public void update(Batch b) {
        batchRepository.save(b);
    }

    @Override
    public void delete(Batch b) {
        batchRepository.delete(b);
    }

    @Override
    public List<Batch> findAll() {
       return batchRepository.findAll();
    }

    @Override
    public Batch findByName(String name) {
        return batchRepository.findByName(name);
    }

    @Override
    public Batch findById(int id) {
        return batchRepository.findById(id).get();
    }

    @Override
    public List<Batch> findByStatus(int status) {
        return batchRepository.findByStatus(status);
    }

    @Override
    public List<Batch> findByStatusAndyearId(int status, int yearid) {
        //yearService.findByYearId(yearid);
        //System.out.println("restapi");
        List<Batch> list= batchRepository.findByStatusAndYearId(status,yearService.findByYearId(yearid)) ;
        //List<Batch> list= batchRepository.findAll() ;
       // System.out.println(list.size());
        return list;
    }

   /* @Override
    public List<RegistedStudent> findByStatusStudent(int status) {
        List<RegistedStudent> list=batchRepository.findByStatus(status);
        return list;
    }*/

    /*@Override
    public List<RegistedStudent> findByStudentId(int status) {
        List<RegistedStudent> list=batchRepository.findByStatusStudent(status);
        return null;
    }*/
}
