package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository

public class InstructorBatchCustomRepositoryImpl implements InstructorBatchCustomRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<InstructorBatch> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM InstructorBatch WHERE status = ?", InstructorBatch.class);

        query.setParameter(1, status);

        List<InstructorBatch> ibList = new ArrayList();
        try {
            if (query.getResultList() != null)
                ibList = query.getResultList();
        } catch (NoResultException e) {

        }
        return ibList;
    }

    @Override
    public List<InstructorBatch> finByInstructorBatchId(Batch batchid, Employee employeeid) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM InstructorBatch WHERE batch_id=? AND employe_id = ?", InstructorBatch.class);

        query.setParameter(1, batchid);
        query.setParameter(2, employeeid);

        List<InstructorBatch> ibList = new ArrayList();
        try {
            if (query.getResultList() != null)
                ibList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;
        return ibList;
    }
}
