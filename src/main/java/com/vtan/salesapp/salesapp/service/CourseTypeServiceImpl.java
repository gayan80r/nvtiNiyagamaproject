package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.CourseType;
import com.vtan.salesapp.salesapp.repository.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    private CourseTypeRepository courseTypeRepository;
    @Override
    public void save(CourseType ct) {
        courseTypeRepository.save(ct);
    }

    @Override
    public void update(CourseType ct) {
        courseTypeRepository.save(ct);
    }

    @Override
    public void delete(CourseType ct) {
        courseTypeRepository.delete(ct);
    }

    @Override
    public CourseType findById(int id) {
       return courseTypeRepository.findById(id).get();
    }

    @Override
    public List<CourseType> findAll() {
        return courseTypeRepository.findAll();
    }
}
