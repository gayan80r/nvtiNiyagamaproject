package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.AlStream;

import java.util.List;

public interface AlStreamService {
    public void save (AlStream as);
    public void update (AlStream as);
    public void delete (AlStream as);
    public AlStream findById(int id);
    public AlStream findByName(String name);
    public List<AlStream> findAll();
    //public List<AlStream> findByStatus(int status);
}
