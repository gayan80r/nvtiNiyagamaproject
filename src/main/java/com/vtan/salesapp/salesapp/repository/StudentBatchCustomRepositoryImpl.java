package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import com.vtan.salesapp.salesapp.entity.Year;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository

public class StudentBatchCustomRepositoryImpl implements StudentBatchCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<StudentBatch> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM StudentBatch WHERE status = ?", StudentBatch.class);

        query.setParameter(1, status);

        List<StudentBatch> sbList = new ArrayList();
        try {
            if (query.getResultList() != null)
                sbList = query.getResultList();
        } catch (NoResultException e) {

        }
        return sbList;
    }

    @Override
    public List<StudentBatch> finByStundentBatchId(Batch batchid, RegistedStudent studentid) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM StudentBatch WHERE batchid=? AND studentid = ?", StudentBatch.class);

        query.setParameter(1, batchid);
        query.setParameter(2, studentid);

        List<StudentBatch> sbList = new ArrayList();
        try {
            if (query.getResultList() != null)
                sbList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;
        return sbList;

    }

    @Override
    public List<StudentBatch> findByBatch(Year yearid) {

        /*Query query =
                entityManager.createNativeQuery("SELECT * FROM StudentBatch WHERE batchid=? ", StudentBatch.class);

        query.setParameter(1, batchid);
        //query.setParameter(2, studentid);

        List<StudentBatch> studentbList = new ArrayList();
        try {
            if (query.getResultList() != null)
                studentbList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;*/
        return null;


    }

    @Override
    public List<StudentBatch> finByStundent(Batch batchid) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM StudentBatch WHERE batchid=? ", StudentBatch.class);

        query.setParameter(1, batchid);
        //query.setParameter(2, studentid);

        List<StudentBatch> studentbList = new ArrayList();
        try {
            if (query.getResultList() != null)
                studentbList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;
        return studentbList;

    }
}
