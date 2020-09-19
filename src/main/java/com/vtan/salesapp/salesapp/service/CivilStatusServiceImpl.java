package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.CivilStatus;
import com.vtan.salesapp.salesapp.repository.CivilStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilStatusServiceImpl implements CivilStatusService {
    @Autowired
    private CivilStatusRepository civilStatusRepository;
    @Override
    public void save(CivilStatus c) {
    civilStatusRepository.save(c);
    }

    @Override
    public void update(CivilStatus c) {
        civilStatusRepository.save(c);
    }

    @Override
    public void delete(CivilStatus c) {
       civilStatusRepository.delete(c);
    }

    @Override
    public List<CivilStatus> findAll() {
        return civilStatusRepository.findAll();
    }
}
