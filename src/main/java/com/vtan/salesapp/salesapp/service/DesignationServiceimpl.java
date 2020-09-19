package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Designation;
import com.vtan.salesapp.salesapp.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DesignationServiceimpl implements DesignationService  {
    @Autowired
    private DesignationRepository designationRepository;
    @Override
    public void save(Designation de) {
        designationRepository.save(de);
    }

    @Override
    public void update(Designation de) {
        designationRepository.save(de);
    }

    @Override
    public void delete(Designation de) {
        designationRepository.delete(de);
    }

    @Override
    public List<Designation> findAll() {
        return designationRepository.findAll();
    }
}
