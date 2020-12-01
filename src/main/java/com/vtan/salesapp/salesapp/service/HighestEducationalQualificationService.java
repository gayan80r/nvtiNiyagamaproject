package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.highestEducationalQualification;

import java.util.List;

public interface HighestEducationalQualificationService {
    public void save (highestEducationalQualification q);
    public void update (highestEducationalQualification q);
    public void delete (highestEducationalQualification q);


    public List<highestEducationalQualification> findAll();
    public highestEducationalQualification findById(int id);
}
