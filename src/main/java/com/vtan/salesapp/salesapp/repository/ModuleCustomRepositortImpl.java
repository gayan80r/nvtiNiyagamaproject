package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Module;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ModuleCustomRepositortImpl implements ModuleCustomRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Module findByName(String name) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM module WHERE name = ?", Module.class);

        query.setParameter(1, name);


        Module mou = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                mou = (Module) query.getSingleResult();
        } catch (NoResultException e) {
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return mou;
    }
}
