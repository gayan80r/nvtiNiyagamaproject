package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.OJTPlace;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class OJTPlaceCustomRepositoryImpl implements OJTPlaceCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public OJTPlace findByName(String name) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM OJTPlace WHERE name = ?", OJTPlace.class);

        query.setParameter(1, name);


        OJTPlace ojtP = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                ojtP = (OJTPlace) query.getSingleResult();
        } catch (NoResultException e) {

        }

        return ojtP;


    }

    @Override
    public OJTPlace findByEmail(String email) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM OJTPlace WHERE email = ?", OJTPlace.class);

        query.setParameter(1, email);


        OJTPlace ojtP = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                ojtP = (OJTPlace) query.getSingleResult();
        } catch (NoResultException e) {

        }

        return ojtP;
    }

    @Override
    public List<OJTPlace> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM OJTPlace WHERE status = ?", OJTPlace.class);

        query.setParameter(1, status);

        List<OJTPlace> ojtPlaceList = new ArrayList();
        try {
            if (query.getResultList() != null)
                ojtPlaceList = query.getResultList();
        } catch (NoResultException e) {

        }
        return ojtPlaceList;
    }
    }

