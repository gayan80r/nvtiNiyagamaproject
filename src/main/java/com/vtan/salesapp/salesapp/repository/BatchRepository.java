package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer>{

    public Batch findByName(String name);
    public List<Batch> findByStatus(int status);
    //public Batch findById(int id);
    public List<Batch> findByStatusAndYearId(int status, Year year);
    //public List<RegistedStudent> findByStatus(int status);
}
