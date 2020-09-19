package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.EmployeeTraining;
import com.vtan.salesapp.salesapp.entity.EmployeeTrainingDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeTrainingDetailsCustomRepositoryImpl implements EmployeeTrainingDetailsCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<EmployeeTrainingDetails> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM EmployeeTrainingDetails WHERE status = ?", EmployeeTrainingDetails.class);

        query.setParameter(1, status);

        List<EmployeeTrainingDetails> etList = new ArrayList();
        try {
            if (query.getResultList() != null)
                etList = query.getResultList();
        } catch (NoResultException e) {

        }
        return etList;
    }

    @Override
    public List<EmployeeTrainingDetails> finByEmployeeTraingId(Employee empid, EmployeeTraining emptraid) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM EmployeeTrainingDetails WHERE employeeid=? AND employeetrainingid = ?", EmployeeTrainingDetails.class);

        query.setParameter(1, empid);
        query.setParameter(2, emptraid);

        List<EmployeeTrainingDetails> etList = new ArrayList();
        try {
            if (query.getResultList() != null)
                etList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;
        return etList;
    }
}
