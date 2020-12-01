package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Department;

import java.util.List;

public interface DepartmentService {
    public void save (Department d);
    public void update (Department d);
    public void delete (Department d);

    public List<Department> findAll();
    public Department findById(int id);
}
