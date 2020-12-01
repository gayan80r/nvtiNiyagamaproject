package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Gender;
import com.vtan.salesapp.salesapp.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenderServiceimpl implements GenderService{
    @Autowired//we add the dependancy injection
    private GenderRepository genderRepository;
    @Override
    public void save(Gender g) {
       genderRepository.save(g);
    }

    @Override
    public void update(Gender g) {
        genderRepository.save(g);
    }

    @Override
    public void delete(Gender g) {
        genderRepository.delete(g);
    }

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Gender findById(int id) {
        return genderRepository.getOne(id);
    }
}
