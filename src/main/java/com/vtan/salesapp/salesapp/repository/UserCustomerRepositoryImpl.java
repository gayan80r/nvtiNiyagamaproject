package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UserCustomerRepositoryImpl implements UserCustomRepository {
    @PersistenceContext
            //EntityManager user for maping the entity class database table
    EntityManager entityManager;



    @Override
    public User findByUsername(String userName) {
        Query query =
                //entityManager.createNativeQuery("SELECT * FROM User WHERE username = ?",User.class);
                entityManager.createNativeQuery("SELECT * FROM systemuser WHERE username = ?",User.class);

        // Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE nic = ?1",Employee.class);

        query.setParameter(1,userName);


        User usr = null;
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                // by issuining query.getSingleResult(); we recieved the object need to User type object
                usr = (User) query.getSingleResult();
        }catch(NoResultException e){
            // need to hancle exception
            // exception need to write in Exception Log file with current time
        }
        return usr;
    }

}
