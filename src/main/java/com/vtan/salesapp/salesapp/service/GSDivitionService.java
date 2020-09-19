package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.GSDivition;

import java.util.List;

public interface GSDivitionService  {
    public void save (GSDivition gd);
    public void update (GSDivition gd);
    public void delete (GSDivition gd);


    public List<GSDivition> findAll();
}
