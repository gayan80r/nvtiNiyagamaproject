package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.CourseDuration;
import com.vtan.salesapp.salesapp.repository.CourseDurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseDurationServiceImpl implements CourseDurationService {
    @Autowired
    private CourseDurationRepository courseDurationRepository;
    @Override
    public void save(CourseDuration cd) {
        courseDurationRepository.save(cd);
    }

    @Override
    public void update(CourseDuration cd) {
        courseDurationRepository.save(cd);
    }

    @Override
    public void delete(CourseDuration cd) {
        courseDurationRepository.delete(cd);
    }

    @Override
    public CourseDuration findById(int id) {
        return courseDurationRepository.findById(id).get();
    }

    @Override
    public List<CourseDuration> findAll() {
       return courseDurationRepository.findAll();
    }
}
