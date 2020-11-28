package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.EmployeeType;
import com.vtan.salesapp.salesapp.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    @Override
    public void save(EmployeeType et) {
        employeeTypeRepository.save(et) ;
    }

    @Override
    public void update(EmployeeType et) {
        employeeTypeRepository.save(et) ;
    }

    @Override
    public void delete(EmployeeType et) {
        employeeTypeRepository.delete(et); ;
    }

    @Override
    public List<EmployeeType> findAll() {
        return employeeTypeRepository.findAll();
    }
}