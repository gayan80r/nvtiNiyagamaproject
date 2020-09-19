package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.StudentBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentBatchRepository extends JpaRepository<StudentBatch,Integer>,StudentBatchCustomRepository {
}
