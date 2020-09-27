package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.SemisterExamGrade;

import java.util.List;

public interface SemisterExamGradeService {
    public void save (SemisterExamGrade eg);
    public void update (SemisterExamGrade eg);
    public void delete (SemisterExamGrade eg);


    public List<SemisterExamGrade> findAll();
}
