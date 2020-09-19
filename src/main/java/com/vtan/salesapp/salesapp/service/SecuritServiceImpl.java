package com.vtan.salesapp.salesapp.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service

public class SecuritServiceImpl implements SecuritService {
    @Override
    public String getLoggedInUserName() {
        //this getDetails() method return object type we need the convert -cast (UserDetails) because getDetails() return the object
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
//SecurityContextHolder class keep the track of loged user as well as other user loging
        //details like session start time and end time,session status

        return details.getUsername();
    }
}
