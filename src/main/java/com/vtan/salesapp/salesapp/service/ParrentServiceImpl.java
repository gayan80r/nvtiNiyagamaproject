package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Parrent;
import com.vtan.salesapp.salesapp.repository.ParrentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParrentServiceImpl implements ParrentService {
    @Autowired
    private ParrentRepository parrentRepository;
    @Override
    public void save(Parrent pa) {
        parrentRepository.save(pa);
    }

    @Override
    public void update(Parrent pa) {
        parrentRepository.save(pa);
    }

    @Override
    public void delete(Parrent pa) {
        parrentRepository.delete(pa);
    }

    @Override
    public Parrent findById(int id) {
        return parrentRepository.findById(id).get();
    }

    @Override
    public Parrent findByNameWithInitial(String name_with_initial) {
        return parrentRepository.findByNameWithInitial(name_with_initial);
    }

    @Override
    public Parrent findByNic(String nic) {
        return parrentRepository.findByNic(nic);
    }

    @Override
    public Parrent findByemail(String email) {
        return parrentRepository.findByemail(email);
    }


    @Override
    public List<Parrent> findAll() {
        return parrentRepository.findAll();
    }

    @Override
    public List<Parrent> findByStatus(boolean status) {
        return parrentRepository.findByStatus(status);
    }
}
