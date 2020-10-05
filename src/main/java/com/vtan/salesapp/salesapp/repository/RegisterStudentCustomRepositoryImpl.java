package com.vtan.salesapp.salesapp.repository;
/*

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Service
public class RegisterStudentCustomRepositoryImpl implements RegisterStudentCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override


    public RegistedStudent findByemail(String email) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM RegistedStudent WHERE email = ?", RegistedStudent.class);

        query.setParameter(1, email);


        RegistedStudent restu = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                restu = (RegistedStudent) query.getSingleResult();
        } catch (NoResultException e) {
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return restu;
    }

    @Override
    public RegistedStudent findByNic(String nic) {
        //entityManager class used the application property files for configure the entityManager class
        //Employee.class used for to create the instance object
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM RegistedStudent WHERE nic = ?", RegistedStudent.class);

        query.setParameter(1, nic);


        RegistedStudent restu = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                restu = (RegistedStudent) query.getSingleResult();
        } catch (NoResultException e) {
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return restu;
    }

    @Override
    public List<RegistedStudent> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM RegistedStudent WHERE status = ?", RegistedStudent.class);

               query.setParameter(1, status);

//we can not create directly the object of List class because List is the interface
//instead we create the object by using the ArrayList class which is the child class of the List class
        List<RegistedStudent> restuList = new ArrayList();
        try {
            if (query.getResultList() != null)
                restuList = query.getResultList();
        } catch (NoResultException e) {
            // need to hancle exception
            // exception need to write in Exception Log file with current time
        }
        return restuList;
    }

    */
/*@Override
    public RegistedStudent findByNameWithInitial(String namewithinitial) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM RegistedStudent WHERE name_with_initial = ?", RegistedStudent.class);

        query.setParameter(1, namewithinitial);

//we can not create directly the object of List class because List is the interface
//instead we create the object by using the ArrayList class which is the child class of the List class
        List<RegistedStudent> restuList = new ArrayList();
        try {
            if (query.getResultList() != null)
                restuList = query.getResultList();
        } catch (NoResultException e) {
            // need to hancle exception
            // exception need to write in Exception Log file with current time
        }
        return restuList;
    }
*//*

}

*/
