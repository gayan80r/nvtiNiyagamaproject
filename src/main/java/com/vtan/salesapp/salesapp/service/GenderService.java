package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Gender;

import java.util.List;

public interface GenderService {
    public void save (Gender g);
    public void update (Gender g);
    public void delete (Gender g);


    public List<Gender> findAll();
}
