package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.OJTPlace;
import com.vtan.salesapp.salesapp.repository.OJTPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OJTPlaceServiceImpl implements OJTPlaceService {
   @Autowired
   private OJTPlaceRepository ojtPlaceRepository;
    @Override
    public void save(OJTPlace o) {
        ojtPlaceRepository.save(o);
    }

    @Override
    public void update(OJTPlace o) {
        ojtPlaceRepository.save(o);
    }

    @Override
    public void delete(OJTPlace o) {
        ojtPlaceRepository.delete(o);
    }

    @Override
    public OJTPlace findById(int id) {
        return ojtPlaceRepository.findById(id).get();
    }

    @Override
    public OJTPlace findByName(String name) {
        return ojtPlaceRepository.findByName(name);
    }

    @Override
    public OJTPlace findByEmail(String email) {
        return ojtPlaceRepository.findByEmail(email);
    }

    @Override
    public List<OJTPlace> findAll() {
        return ojtPlaceRepository.findAll();
    }

    @Override
    public List<OJTPlace> findByStatus(boolean status) {
        return ojtPlaceRepository.findByStatus(status);
    }
}
