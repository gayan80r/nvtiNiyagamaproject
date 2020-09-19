package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.NvqLevel;
import com.vtan.salesapp.salesapp.repository.NvqLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NvqlevelServiceImpl implements NvqlevelService {
    @Autowired
    private NvqLevelRepository nvqLevelRepository;
    @Override
    public void save(NvqLevel nl) {
        nvqLevelRepository.save(nl);
    }

    @Override
    public void update(NvqLevel nl) {
        nvqLevelRepository.save(nl);
    }

    @Override
    public void delete(NvqLevel nl) {
        nvqLevelRepository.delete(nl);
    }

    @Override
    public NvqLevel findById(int id) {
        return nvqLevelRepository.findById(id).get();
    }

    @Override
    public List<NvqLevel> findAll() {
        return nvqLevelRepository.findAll();
    }
}
