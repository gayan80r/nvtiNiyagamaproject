package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Year;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
//@Service
/*public class BatchCustomRepositoryImpl implements BatchCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Batch findByName(String name) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Batch WHERE name = ?", Batch.class);

        query.setParameter(1, name);


        Batch bat = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                bat = (Batch) query.getSingleResult();
        } catch (NoResultException e) {
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return bat;
    }


    @Override
    public List<Batch> findByStatus(int status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM Batch WHERE status = ?", Batch.class);

        query.setParameter(1, status);

        List<Batch> batList = new ArrayList();
        try {
            if (query.getResultList() != null)
                batList = query.getResultList();
        } catch (NoResultException e) {

        }
        return batList;
    }

   *//* @Override
    public List<Batch> findByStatusAndyearId(boolean status, Year year) {
        return null;
    }*/
//}

