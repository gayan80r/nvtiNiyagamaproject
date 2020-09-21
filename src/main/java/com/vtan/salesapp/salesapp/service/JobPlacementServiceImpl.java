package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.JobPlacement;
import com.vtan.salesapp.salesapp.repository.JobPlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobPlacementServiceImpl implements JobPlacementService {

    @Autowired
    private JobPlacementRepository jobPlacementRepository;
    @Override
    public void save(JobPlacement j) {
        jobPlacementRepository.save(j);
    }

    @Override
    public void update(JobPlacement j) {
        jobPlacementRepository.save(j);
    }

    @Override
    public void delete(JobPlacement j) {
        jobPlacementRepository.delete(j);
    }

    @Override
    public JobPlacement findById(int id) {
        return jobPlacementRepository.findById(id).get();
    }

    @Override
    public JobPlacement findByName(String name) {
        return jobPlacementRepository.findByName(name);
    }

    @Override
    public JobPlacement findByEmail(String email) {
        return jobPlacementRepository.findByEmail(email);
    }

    @Override
    public List<JobPlacement> findByStatus(boolean status) {
        return jobPlacementRepository.findByStatus(status);
    }

    @Override
    public List<JobPlacement> findAll() {
        return jobPlacementRepository.findAll();
    }
}
