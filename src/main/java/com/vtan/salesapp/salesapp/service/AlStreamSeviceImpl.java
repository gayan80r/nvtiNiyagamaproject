package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.AlStream;
import com.vtan.salesapp.salesapp.repository.AlStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlStreamSeviceImpl implements AlStreamService{
    @Autowired
    private AlStreamRepository alStreamRepository;
    @Override

    public void save(AlStream as) {
        alStreamRepository.save(as);
    }

    @Override
    public void update(AlStream as) {
        alStreamRepository.save(as);
    }

    @Override
    public void delete(AlStream as) {
        alStreamRepository.delete(as);
    }

    @Override
    public AlStream findById(int id) {
        return alStreamRepository.findById(id).get();
    }

    @Override
    public AlStream findByName(String name) {
        return alStreamRepository.findByName(name);
    }

    @Override
    public List<AlStream> findAll() {
        return alStreamRepository.findAll();
    }

   /* @Override
    public List<AlStream> findByStatus(int status) {
        return alStreamRepository.findByStatus(status);
    }*/
}
