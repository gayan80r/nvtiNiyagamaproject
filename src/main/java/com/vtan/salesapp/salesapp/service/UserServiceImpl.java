package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.User;
import com.vtan.salesapp.salesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    //by using the @Autowired anotation can be used variable with out the initiate by usng the new
    //key word
    private UserRepository userRepository;

    @Override
    public void save(User g) {
        userRepository.save(g);
    }

    @Override
    public void update(User g) {
        userRepository.save(g);
    }

    @Override
    public void delete(User g) {
        userRepository.delete(g);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String userName) {
        //return userRepository.findByUsername(userName);
        return userRepository.findByUsername(userName);
    }

}

