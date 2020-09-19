package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Batch;

import java.util.List;

public interface BatchCustomRepository {
    public Batch findByName(String name);
    public List<Batch> findByStatus(boolean status);
    //public Batch findById(int id);

}
