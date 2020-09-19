package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepository batchRepository;
    @Override
    public void save(Batch b) {
        batchRepository.save(b);
    }

    @Override
    public void update(Batch b) {
        batchRepository.save(b);
    }

    @Override
    public void delete(Batch b) {
        batchRepository.delete(b);
    }

    @Override
    public List<Batch> findAll() {
       return batchRepository.findAll();
    }

    @Override
    public Batch findByName(String name) {
        return batchRepository.findByName(name);
    }

    @Override
    public Batch findById(int id) {
        return batchRepository.findById(id).get();
    }

    @Override
    public List<Batch> findByStatus(boolean status) {
        return batchRepository.findByStatus(status);
    }
}
