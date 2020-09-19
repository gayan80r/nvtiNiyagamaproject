package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.DevitionalSecatary;

import java.util.List;

public interface DevitionalSecataryService {
    public void save (DevitionalSecatary ds);
    public void update (DevitionalSecatary ds);
    public void delete (DevitionalSecatary ds);


    public List<DevitionalSecatary> findAll();
}
