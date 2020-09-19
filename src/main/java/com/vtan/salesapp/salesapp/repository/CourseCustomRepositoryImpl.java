package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Course;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseCustomRepositoryImpl implements CourseCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Course findByName(String name) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Course WHERE name = ?", Course.class);

        query.setParameter(1, name);


        Course cou = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                cou = (Course) query.getSingleResult();
        } catch (NoResultException e) {
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return cou;
    }

    @Override
    public List<Course> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM Course WHERE status = ?", Course.class);

        query.setParameter(1, status);

        List<Course> couList = new ArrayList();
        try {
            if (query.getResultList() != null)
                couList = query.getResultList();
        } catch (NoResultException e) {

        }
        return couList;
    }
}
