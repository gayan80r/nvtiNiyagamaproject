package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.JobPlacement;

import java.util.List;

public interface JobPlacementCustomRepository {
    public JobPlacement findByName(String name);
    public JobPlacement findByEmail(String email);
    public List<JobPlacement> findByStatus(boolean status);
}
