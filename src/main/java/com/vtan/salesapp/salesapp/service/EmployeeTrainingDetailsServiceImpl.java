package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.EmployeeTraining;
import com.vtan.salesapp.salesapp.entity.EmployeeTrainingDetails;
import com.vtan.salesapp.salesapp.repository.EmployeeTrainingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTrainingDetailsServiceImpl implements EmployeeTrainingDetailsService {
    @Autowired
    private EmployeeTrainingDetailsRepository employeeTrainingDetailsRepository;
    @Override
    public void save(EmployeeTrainingDetails etd) {
        employeeTrainingDetailsRepository.save(etd);
    }

    @Override
    public void update(EmployeeTrainingDetails etd) {
        employeeTrainingDetailsRepository.save(etd);
    }

    @Override
    public void delete(EmployeeTrainingDetails etd) {
        employeeTrainingDetailsRepository.delete(etd);
    }

    @Override
    public EmployeeTrainingDetails findById(int id) {
        return employeeTrainingDetailsRepository.findById(id).get();
    }

    @Override
    public List<EmployeeTrainingDetails> findByStatus(boolean status) {
        return employeeTrainingDetailsRepository.findByStatus(status);
    }

    @Override
    public List<EmployeeTrainingDetails> findAll() {
        return employeeTrainingDetailsRepository.findAll();
    }

    @Override
    public List<EmployeeTrainingDetails> findByEmployeeTrainingId(Employee empid, EmployeeTraining emptraid) {
        return employeeTrainingDetailsRepository.finByEmployeeTraingId(empid,emptraid);
    }
}
