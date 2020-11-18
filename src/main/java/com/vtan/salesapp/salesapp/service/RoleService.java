package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Role;

import java.util.List;

public interface RoleService {
    public void save (Role role);
    public void update (Role role);
    public void delete (Role role);
    public Role findById(int id);
    public List<Role> findAll();
}
