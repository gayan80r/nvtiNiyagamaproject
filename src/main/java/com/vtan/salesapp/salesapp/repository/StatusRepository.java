package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
