package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Employee;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

public class EmployeeCustomerRepositoryIml implements EmployeeCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Employee findByemail(String email) {
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Employee WHERE email = ?",Employee.class);

        query.setParameter(1,email);


        Employee emp = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                emp = (Employee) query.getSingleResult();
        }catch(NoResultException e){
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return emp;
    }

    public Employee findByNic(String nic) {
//createNativeQuery method return type is query therefore we need to convert the Query type of data

        //entityManager class used the application property files for configure the entityManager class
        //Employee.class used for to create the instance object
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM Employee WHERE nic = ?",Employee.class);

        query.setParameter(1,nic);


        Employee emp = null;
        //query.getSingleResult() method default behavior is the pass no result null
        //therefore we handle exception with NoResultException
        try {
            if (query.getSingleResult() != null)
                // Java Casting - Force Conversion of Data Types
                emp = (Employee) query.getSingleResult();
        }catch(NoResultException e){
            // need to handle exception
            // exception need to write in Exception Log file with current time
        }

        return emp;
    }
    @Override
    public List<Employee> findByStatus(boolean status){


        Query query =
                entityManager.createNativeQuery("SELECT * FROM Employee WHERE status = ?",Employee.class);

        // Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE nic = ?1",Employee.class);

        query.setParameter(1,status);

//we can not create directly the object of List class because List is the interface
//instead we create the object by using the ArrayList class which is the child class of the List class
        List<Employee> empList = new ArrayList();
        try {
            if (query.getResultList() != null)
                empList =  query.getResultList();
        }catch(NoResultException e){
            // need to hancle exception
            // exception need to write in Exception Log file with current time
        }
        return empList;


    }

}
