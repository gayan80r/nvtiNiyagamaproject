package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.InstructorBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorBatchRepository extends JpaRepository<InstructorBatch,Integer> ,InstructorBatchCustomRepository{
}
