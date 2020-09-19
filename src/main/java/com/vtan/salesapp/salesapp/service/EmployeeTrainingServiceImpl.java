package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.EmployeeTraining;
import com.vtan.salesapp.salesapp.repository.EmployeeTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTrainingServiceImpl implements EmployeeTrainingService {
@Autowired
private EmployeeTrainingRepository employeeTrainingRepository;


    @Override
    public void save(EmployeeTraining et) {
        employeeTrainingRepository.save(et);
    }

    @Override
    public void update(EmployeeTraining et) {
        employeeTrainingRepository.save(et);
    }

    @Override
    public void delete(EmployeeTraining et) {
        employeeTrainingRepository.delete(et);
    }

    @Override
    public EmployeeTraining findById(int id) {
        return employeeTrainingRepository.findById(id).get();
    }

    /*@Override
    public List<EmployeeTraining> findByStatus(boolean status) {
        return employeeTrainingRepository.findByStatus(status);
    }*/

    @Override
    public List<EmployeeTraining> findAll() {
        return employeeTrainingRepository.findAll();
    }
}
