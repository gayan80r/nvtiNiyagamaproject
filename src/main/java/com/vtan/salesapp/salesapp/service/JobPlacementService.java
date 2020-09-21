package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.JobPlacement;

import java.util.List;

public interface JobPlacementService {
    public void save (JobPlacement j);
    public void update (JobPlacement j);
    public void delete (JobPlacement j );
    public JobPlacement  findById(int id);
    public JobPlacement  findByName(String name);
    public JobPlacement  findByEmail(String email);
    public List<JobPlacement > findByStatus(boolean status);
    public List<JobPlacement > findAll();
}
