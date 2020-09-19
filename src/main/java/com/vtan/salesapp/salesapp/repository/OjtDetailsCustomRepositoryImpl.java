package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.OJTPlace;
import com.vtan.salesapp.salesapp.entity.OjtDetails;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OjtDetailsCustomRepositoryImpl  implements OjtDetailsCustomRepository{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<OjtDetails> findByStatus(boolean status) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM OjtDetails WHERE status = ?", OjtDetails.class);

        query.setParameter(1, status);

        List<OjtDetails> ojtList = new ArrayList();
        try {
            if (query.getResultList() != null)
                ojtList = query.getResultList();
        } catch (NoResultException e) {

        }
        return ojtList;
    }

    @Override
    public List<OjtDetails> finByOjtDetailsId( RegistedStudent studentid,OJTPlace ojtid) {
        Query query =
                entityManager.createNativeQuery("SELECT * FROM OjtDetails WHERE studentid=? AND ojtid = ?", OjtDetails.class);

        query.setParameter(1, studentid);
        query.setParameter(2, ojtid);

        List<OjtDetails> ojtList = new ArrayList();
        try {
            if (query.getResultList() != null)
                ojtList = query.getResultList();
        } catch (NoResultException e) {

        }
        //return (StudentBatch) sbList;
        return ojtList;
    }
}
