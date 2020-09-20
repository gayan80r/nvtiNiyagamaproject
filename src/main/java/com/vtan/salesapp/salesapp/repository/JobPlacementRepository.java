package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.JobPlacement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPlacementRepository extends JpaRepository<JobPlacement,Integer>, JobPlacementCustomRepository{
}
