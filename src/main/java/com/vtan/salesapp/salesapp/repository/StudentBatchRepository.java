package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentBatchRepository extends JpaRepository<StudentBatch,Integer>,StudentBatchCustomRepository {
 //   List<StudentBatch> finByStundent(Batch batchid);
}
