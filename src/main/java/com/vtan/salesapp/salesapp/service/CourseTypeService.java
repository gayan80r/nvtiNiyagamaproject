package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.CourseType;

import java.util.List;

public interface CourseTypeService  {
    public void save (CourseType ct);
    public void update (CourseType ct);
    public void delete (CourseType ct);
    public CourseType findById(int id);
    public List<CourseType > findAll();
}
