package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.GSDivition;
import com.vtan.salesapp.salesapp.repository.GSDevisionRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GSDivitionServiceImpl implements GSDivitionService{
    @Autowired
    private GSDevisionRepositoty gsDevisionRepositoty;
    @Override
    public void save(GSDivition gd) {
        gsDevisionRepositoty.save(gd);
    }

    @Override
    public void update(GSDivition gd) {
        gsDevisionRepositoty.save(gd);
    }

    @Override
    public void delete(GSDivition gd) {
        gsDevisionRepositoty.delete(gd);
    }

    @Override
    public List<GSDivition> findAll() {
        return gsDevisionRepositoty.findAll();
    }
}
