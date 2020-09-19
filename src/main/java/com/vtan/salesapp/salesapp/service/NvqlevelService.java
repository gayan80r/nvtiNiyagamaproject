package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.NvqLevel;

import java.util.List;

public interface NvqlevelService {
    public void save (NvqLevel nl);
    public void update (NvqLevel nl);
    public void delete (NvqLevel nl);
    public NvqLevel findById(int id);
    public List<NvqLevel > findAll();
}
