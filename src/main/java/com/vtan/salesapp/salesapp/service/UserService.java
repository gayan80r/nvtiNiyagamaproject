package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.User;

import java.util.List;

public interface UserService {
    public void save (User g);
    public void update (User g);
    public void delete (User g);

    public User findByUsername(String userName);


    public List<User> findAll();
}
