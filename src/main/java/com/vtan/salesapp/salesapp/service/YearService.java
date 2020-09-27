package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Gender;
import com.vtan.salesapp.salesapp.entity.Year;

import java.util.List;

public interface YearService {
    public void save (Year y);
    public void update (Year y);
    public void delete (Year y);


    public List<Year> findAll();
}
