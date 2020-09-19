package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Module;
import com.vtan.salesapp.salesapp.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleServiceImpl implements ModuleSevice {
@Autowired
private ModuleRepository moduleRepository;
    @Override
    public void save(Module mo) {
        moduleRepository.save(mo);
    }

    @Override
    public void update(Module mo) {
        moduleRepository.save(mo);
    }

    @Override
    public void delete(Module mo) {
        moduleRepository.delete(mo);
    }

    @Override
    public Module findById(int id) {
        return moduleRepository.findById(id).get();
    }

    @Override
    public Module findByName(String name) {
        return moduleRepository.findByName(name);
    }

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }
}
