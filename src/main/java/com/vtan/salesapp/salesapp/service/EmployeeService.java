package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void save (Employee e);
    public void update (Employee e);
    public void delete (Employee e);

    public Employee findById(int id);
    public Employee findByNic(String nic);
    public Employee findByemail(String email);

    //public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();

    public List<Employee > findAll();
    public List<Employee> findByStatus(boolean status);

}
