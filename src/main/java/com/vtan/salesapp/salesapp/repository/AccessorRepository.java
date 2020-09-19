package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Accessor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessorRepository extends JpaRepository<Accessor,Integer>,AccessorCustomRepository {
}
