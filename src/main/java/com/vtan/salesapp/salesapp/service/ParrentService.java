package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Parrent;

import java.util.List;

public interface ParrentService {
    public void save (Parrent pa);
    public void update (Parrent pa);
    public void delete (Parrent pa);
    public Parrent findById(int id);
    public Parrent findByNameWithInitial(String name_with_initial);


    public Parrent findByNic(String nic);
    public Parrent findByemail(String email);
    public List<Parrent> findAll();
    public List<Parrent> findByStatus(boolean status);
}
