package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.User;
import com.vtan.salesapp.salesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//we do not create the UserDetailsService because it is built in the spring security
//security.core.userdetails.UserDetailsService;
//user details class used to keep the details of the loged user
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    //some one reused the loadUserByUsername method need the handle try catch block
    //this methord return type is UserDetails
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User usr = userRepository.findByUsername(username);
        if (usr == null)
            System.out.println("User not available");
//we can not create the instance-object UserDetails because it is a interface
        //therefore can be created the object by using user class which is implemented class of the UserDetails
        //there are two types of  users class first one is our user entity class other one is the org.springframework.security.core.userdetails
       // UserDetails uDetails =
                //new org.springframework.security.core.userdetails
                        //.User(usr.getUsername(), usr.getPassword(), null);
        //User usr = userRepository.findByUsername(username); we get the usr object then
        //we add UserDetails uDetails of the spring security object with authorization
        //uDetails+usr with privilages
//we can not directly create the instance of List because List is the interface
        //there is implemented class of the List is ArrayList
        //a user have one or more role therefor we create the role list
        List<GrantedAuthority> roleList = new ArrayList();
//we create the rolelist data type is GrantedAuthority
        //we want to GrantedAuthority object but can not be create the instance instead of
        // there is implemented class called SimpleGrantedAuthority
        roleList.add(new SimpleGrantedAuthority(usr.getRole().getName()));

        UserDetails uDetails =
                new org.springframework.security.core.userdetails
                        .User(usr.getUsername(),usr.getPassword(),roleList);

        return uDetails;

    }

}