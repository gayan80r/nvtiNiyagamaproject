
package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.EmployeeType;

import java.util.List;

public interface EmployeeTypeService {
    public void save (EmployeeType et);
    public void update (EmployeeType et);
    public void delete (EmployeeType et);


    public List<EmployeeType > findAll();
    public EmployeeType findById(int id);
}