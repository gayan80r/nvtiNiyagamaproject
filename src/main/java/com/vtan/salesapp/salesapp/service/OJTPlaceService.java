package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.OJTPlace;

import java.util.List;

public interface OJTPlaceService {
    public void save (OJTPlace o);
    public void update (OJTPlace o);
    public void delete (OJTPlace o );
    public OJTPlace findById(int id);
    public OJTPlace findByName(String name);
    public OJTPlace findByEmail(String email);
    public List<OJTPlace> findByStatus(boolean status);
    public List<OJTPlace> findAll();

}
