package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.OjtDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OjtDetailsRepository extends JpaRepository<OjtDetails,Integer> ,OjtDetailsCustomRepository{
}
