package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Parrent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParrentRepository extends JpaRepository<Parrent,Integer>,ParrentCustomRepository {
}
