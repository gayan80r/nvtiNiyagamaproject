package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Accessor;
import com.vtan.salesapp.salesapp.repository.AccessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessorServiceImpl implements AccessorService{
    @Autowired
    private AccessorRepository accessorRepository;
    @Override
    public void save(Accessor a) {
        accessorRepository.save(a);
    }

    @Override
    public void update(Accessor a) {
        accessorRepository.save(a);
    }

    @Override
    public void delete(Accessor a) {
        accessorRepository.delete(a);
    }

    @Override
    public Accessor findById(int id) {
        return accessorRepository.findById(id).get();
    }

    @Override
    public Accessor findByNic(String nic) {
      return accessorRepository.findByNic(nic);
    }

    @Override
    public Accessor findByemail(String email) {
       return accessorRepository.findByemail(email);
    }

    @Override
    public List<Accessor> findByStatus(boolean status) {
      return accessorRepository.findByStatus(status);
    }

    @Override
    public List<Accessor> getAllEmployees() {
        return accessorRepository.findAll();
    }

    @Override
    public List<Accessor> findAll() {
        return accessorRepository.findAll();
    }
}
