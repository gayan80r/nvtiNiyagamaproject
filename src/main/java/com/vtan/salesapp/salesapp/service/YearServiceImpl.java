package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Year;
import com.vtan.salesapp.salesapp.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YearServiceImpl implements YearService {
  @Autowired
   private YearRepository yearRepository;
    @Override
    public void save(Year y) {
        yearRepository.save(y);
    }

    @Override
    public void update(Year y) {
        yearRepository.save(y);
    }

    @Override
    public void delete(Year y) {
        yearRepository.delete(y);
    }

    @Override
    public Year findByYearId(int yearid) {
        return yearRepository.findById(yearid).get();
    }

    @Override
    public List<Year> findAll() {
        return yearRepository.findAll();
    }
}
