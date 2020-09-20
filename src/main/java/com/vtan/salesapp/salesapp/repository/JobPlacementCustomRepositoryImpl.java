package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.JobPlacement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class JobPlacementCustomRepositoryImpl implements JobPlacementCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public JobPlacement findByName(String name) {
        Query query = (Query) entityManager.createNativeQuery("SELECT *  FROM JobPlacement WHERE name = ?", JobPlacement.class);

        query.setParameter(1, name);


        JobPlacement jobpl = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                jobpl = (JobPlacement) query.getSingleResult();
        } catch (NoResultException e) {

        }

        return jobpl;

    }

    @Override
    public JobPlacement findByEmail(String email) {
        Query query = (Query) entityManager.createNativeQuery("SELECT *  FROM JobPlacement WHERE email = ?", JobPlacement.class);

        query.setParameter(1, email);


        JobPlacement jobpl = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                jobpl = (JobPlacement) query.getSingleResult();
        } catch (NoResultException e) {

        }

        return jobpl;
    }

    @Override
    public List<JobPlacement> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM JobPlacement WHERE status = ?", JobPlacement.class);

        query.setParameter(1, status);

        List<JobPlacement> jobPlaceList = new ArrayList();
        try {
            if (query.getResultList() != null)
                jobPlaceList = query.getResultList();
        } catch (NoResultException e) {

        }
        return jobPlaceList;
    }
    }

