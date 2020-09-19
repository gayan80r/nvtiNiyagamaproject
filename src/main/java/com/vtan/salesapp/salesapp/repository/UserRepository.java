package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//unable dependancy injection features
//Interger is the primary key data type

public interface UserRepository extends JpaRepository<User,Integer>,UserCustomRepository {


}
