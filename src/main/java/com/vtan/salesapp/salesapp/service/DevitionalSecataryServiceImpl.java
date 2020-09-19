package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.DevitionalSecatary;
import com.vtan.salesapp.salesapp.repository.DevitionalSecataryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class DevitionalSecataryServiceImpl implements DevitionalSecataryService {

    @Autowired
private DevitionalSecataryRepository devitionalSecataryRepository;
    @Override
    public void save(DevitionalSecatary ds) {
        devitionalSecataryRepository.save(ds);
    }

    @Override
    public void update(DevitionalSecatary ds) {
        devitionalSecataryRepository.save(ds);
    }

    @Override
    public void delete(DevitionalSecatary ds) {
        devitionalSecataryRepository.delete(ds);
    }



    @Override
    public List<DevitionalSecatary> findAll() {
        return devitionalSecataryRepository.findAll();
    }
}
