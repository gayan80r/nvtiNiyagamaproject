package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Parrent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Service
public class ParrentCustomRepositoryImpl implements ParrentCustomRepository {
   @PersistenceContext
    EntityManager entityManager;

    @Override
    public Parrent findByNameWithInitial(String name_with_initial) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Parrent WHERE name_with_initial = ?", Parrent.class);

        query.setParameter(1, name_with_initial);


        Parrent par = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                par = (Parrent) query.getSingleResult();
        } catch (NoResultException e) {
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return par;
    }

    @Override
    public List<Parrent> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM Parrent WHERE status = ?", Parrent.class);

        query.setParameter(1, status);

        List<Parrent> parrList = new ArrayList();
        try {
            if (query.getResultList() != null)
                parrList = query.getResultList();
        } catch (NoResultException e) {

        }
        return parrList;
    }

    @Override
    public Parrent findByemail(String email) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Parrent WHERE email = ?",Parrent.class);

        query.setParameter(1,email);


        Parrent par = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                par = (Parrent) query.getSingleResult();
        }catch(NoResultException e){
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return par;
    }

    @Override
    public Parrent findByNic(String nic) {
        //entityManager class used the application property files for configure the entityManager class
        //Employee.class used for to create the instance object
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Parrent WHERE nic = ?",Parrent.class);

        query.setParameter(1,nic);


        Parrent par = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                par = (Parrent) query.getSingleResult();
        }catch(NoResultException e){
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return par;
    }
}

