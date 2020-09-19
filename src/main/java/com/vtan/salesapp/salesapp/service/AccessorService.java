package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Accessor;

import java.util.List;

public interface AccessorService {
    public void save (Accessor a);
    public void update (Accessor a);
    public void delete (Accessor a);
    public Accessor  findById(int id);

    public Accessor findByNic(String nic);
    public Accessor findByemail(String email);
    public List<Accessor> findByStatus(boolean status);
    //public Employee getEmployeeById(int id);
    public List<Accessor> getAllEmployees();

    public List<Accessor > findAll();
    ;
}
