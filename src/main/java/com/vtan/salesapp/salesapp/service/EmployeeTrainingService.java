package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface EmployeeTrainingService {
    public void save (EmployeeTraining et);
    public void update (EmployeeTraining et);
    public void delete (EmployeeTraining et);
    public EmployeeTraining   findById(int id);

    //public List<EmployeeTraining  > findByStatus(boolean status);
    public List<EmployeeTraining  > findAll();
}
