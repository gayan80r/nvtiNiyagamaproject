package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Module;

import java.util.List;

public interface ModuleSevice {
    public void save (Module mo);
    public void update (Module mo);
    public void delete (Module mo);
    public Module findById(int id);
    public Module findByName(String name);
    public List<Module> findAll();
}
