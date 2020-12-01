package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.highestVocationalQualification;

import java.util.List;

public interface HighestVocationalQualificationService {
    public void save (highestVocationalQualification vq);
    public void update (highestVocationalQualification vq);
    public void delete (highestVocationalQualification vq);


    public List<highestVocationalQualification> findAll();
    public highestVocationalQualification findById(int id);
}
