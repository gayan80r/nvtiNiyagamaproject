package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.EmployeeLeave;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeLeaveCustomRepositoryImpl implements EmployeeLeaveCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<EmployeeLeave> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM EmployeeLeave WHERE status = ?", EmployeeLeave.class);

        query.setParameter(1, status);

        List<EmployeeLeave> empleaveList = new ArrayList();
        try {
            if (query.getResultList() != null)
                empleaveList = query.getResultList();
        } catch (NoResultException e) {

        }
        return empleaveList;
    }

    @Override
    public List<EmployeeLeave> finByEmployeeStartEndDate(EmployeeLeave epf_no, EmployeeLeave startdate, EmployeeLeave enddate) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM EmployeeLeave WHERE epf_no=? AND startdate = ? AND enddate = ?", EmployeeLeave.class);

        query.setParameter(1, epf_no);
        query.setParameter(2, startdate);
        query.setParameter(2, enddate);

        List<EmployeeLeave> empleaveList = new ArrayList();
        try {
            if (query.getResultList() != null)
                empleaveList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;
        return empleaveList;

    }
}
