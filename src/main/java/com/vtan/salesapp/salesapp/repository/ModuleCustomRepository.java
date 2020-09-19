package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Module;

public interface ModuleCustomRepository {
    public Module findByName(String name);
}
