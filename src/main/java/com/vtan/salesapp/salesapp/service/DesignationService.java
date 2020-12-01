package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Designation;

import java.util.List;

public interface DesignationService {
    public void save (Designation de);
    public void update (Designation de);
    public void delete (Designation de);


    public List<Designation> findAll();
    public Designation findById(int id);
}
