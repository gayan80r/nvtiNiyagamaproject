package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Accessor;
import com.vtan.salesapp.salesapp.entity.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccessorCustomRepositoryImpl implements AccessorCustomRepository {
@PersistenceContext
    EntityManager entityManager;
    @Override
    public Accessor findByemail(String email) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Accessor WHERE email = ?",Accessor.class);

        query.setParameter(1,email);


        Accessor acc = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                acc = (Accessor) query.getSingleResult();
        }catch(NoResultException e){
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return acc;
    }

    @Override
    public Accessor findByNic(String nic) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Accessor WHERE nic = ?", Accessor.class);

        query.setParameter(1,nic);


        Accessor acc = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                acc = (Accessor) query.getSingleResult();;
        }catch(NoResultException e){
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return acc;
    }

    @Override
    public List<Accessor> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM Accessor WHERE status = ?",Accessor.class);

        // Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE nic = ?1",Employee.class);

        query.setParameter(1,status);

//we can not create directly the object of List class because List is the interface
//instead we create the object by using the ArrayList class which is the child class of the List class
        List<Accessor> accList = new ArrayList();
        try {
            if (query.getResultList() != null)
                accList =  query.getResultList();
        }catch(NoResultException e){
            // need to hancle exception
            // exception need to write in Exception Log file with current time
        }
        return accList;


    }
}
