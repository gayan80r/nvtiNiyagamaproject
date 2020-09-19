package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Semister;

import java.util.List;

public interface SemisterService {
    public void save (Semister se);
    public void update (Semister se);
    public void delete (Semister se);
    //public Semister findById(int id);
    //public Semister findByName(String name);
    public List<Semister > findAll();
}
