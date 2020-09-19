package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//unable dependancy injection features
public interface GenderRepository extends JpaRepository<Gender,Integer> {

}
