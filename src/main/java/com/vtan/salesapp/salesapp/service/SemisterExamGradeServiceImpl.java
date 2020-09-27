package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.SemisterExamGrade;
import com.vtan.salesapp.salesapp.repository.SemisterExamGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SemisterExamGradeServiceImpl implements SemisterExamGradeService {
    @Autowired
    private SemisterExamGradeRepository semisterExamGradeRepository;
    @Override
    public void save(SemisterExamGrade eg) {
        semisterExamGradeRepository.save(eg);
    }

    @Override
    public void update(SemisterExamGrade eg) {
        semisterExamGradeRepository.save(eg);
    }

    @Override
    public void delete(SemisterExamGrade eg) {
        semisterExamGradeRepository.delete(eg);
    }

    @Override
    public List<SemisterExamGrade> findAll() {
        return semisterExamGradeRepository.findAll();
    }
}
