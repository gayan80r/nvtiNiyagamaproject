package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Parrent;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentParrent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentParrentCustomeRepositoryImpl implements StudentParrentCustomeRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<StudentParrent> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM StudentParrent WHERE status = ?", StudentParrent.class);

        query.setParameter(1, status);

        List<StudentParrent> spList = new ArrayList();
        try {
            if (query.getResultList() != null)
                spList = query.getResultList();
        } catch (NoResultException e) {

        }
        return spList;
    }

    @Override
    public List<StudentParrent> finByStundentParrendId(Parrent parrentId, RegistedStudent studentId) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM StudentParrent WHERE parrent_id=? AND student_id = ?", StudentParrent.class);

        query.setParameter(1, parrentId);
        query.setParameter(2, studentId);

        List<StudentParrent> spList = new ArrayList();
        try {
            if (query.getResultList() != null)
                spList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;
        return spList;
    }




}
