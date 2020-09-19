package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Semister;
import com.vtan.salesapp.salesapp.repository.SemisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SemisterServiceImpl implements SemisterService {
    @Autowired
    private SemisterRepository semisterRepository;
    @Override
    public void save(Semister se) {
        semisterRepository.save(se);
    }

    @Override
    public void update(Semister se) {
        semisterRepository.save(se);
    }

    @Override
    public void delete(Semister se) {
        semisterRepository.save(se);
    }

    /*@Override
    public Semister findById(Semister id) {
        return semisterRepository.findById(id).get();;
    }*/

   /* @Override
    public Semister findByName(String name) {
        return semisterRepository.f;
    }*/

    @Override
    public List<Semister> findAll() {
        return semisterRepository.findAll();
    }
}
