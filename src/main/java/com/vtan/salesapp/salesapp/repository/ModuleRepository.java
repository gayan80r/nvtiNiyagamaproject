package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module,Integer>,ModuleCustomRepository {
}
