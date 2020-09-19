package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.OJTPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OJTPlaceRepository extends JpaRepository<OJTPlace,Integer>,OJTPlaceCustomRepository {
}
