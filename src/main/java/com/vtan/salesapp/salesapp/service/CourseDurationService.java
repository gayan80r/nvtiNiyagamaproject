package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.CourseDuration;

import java.util.List;

public interface CourseDurationService {
    public void save (CourseDuration cd);
    public void update (CourseDuration cd);
    public void delete (CourseDuration cd);
    public CourseDuration findById(int id);
    public List<CourseDuration > findAll();
}
