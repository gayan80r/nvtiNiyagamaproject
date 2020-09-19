package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.EmployeeTraining;
import com.vtan.salesapp.salesapp.entity.EmployeeTrainingDetails;

import java.util.List;

public interface EmployeeTrainingDetailsService {
    public void save (EmployeeTrainingDetails etd);
    public void update (EmployeeTrainingDetails etd);
    public void delete (EmployeeTrainingDetails etd);
    public EmployeeTrainingDetails   findById(int id);

    public List<EmployeeTrainingDetails  > findByStatus(boolean status);
    public List<EmployeeTrainingDetails  > findAll();
    public List<EmployeeTrainingDetails >  findByEmployeeTrainingId(Employee empid, EmployeeTraining emptraid);
}
