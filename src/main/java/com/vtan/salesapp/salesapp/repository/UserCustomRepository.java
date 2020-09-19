package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.User;

public interface UserCustomRepository {
    public User findByUsername(String userName);

}
