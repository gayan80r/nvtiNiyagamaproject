package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    //we can not directlly create object EmployeeRepository because it is interface
    //we  use DI
    private EmployeeRepository employeeRepository;
    @Override
    //override the save method of the EmployeeService
    public void save(Employee e) {
      employeeRepository.save(e);
    }

    @Override
    public void update(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public void delete(Employee e) {
        employeeRepository.delete(e);
    }

    @Override
    public Employee findById(int id) {
        //get() get the employee  optional data type used to handle null point exception
        return employeeRepository.findById(id).get();

    }

    @Override

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    //return type of the findByNic is Employee non primitive type
    public Employee findByNic(String nic){
//now we can call the method findByNic(nic) of the EmployeeRepository class object
        return employeeRepository.findByNic(nic);
    }

    @Override
    public Employee findByemail(String email) {
        return employeeRepository.findByEmail(email);
    }

    /*@Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
*/
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByStatus(boolean status){

        return employeeRepository.findByStatus(status);
    }



}
