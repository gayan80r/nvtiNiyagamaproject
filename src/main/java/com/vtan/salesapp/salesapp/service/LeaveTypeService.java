package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Gender;
import com.vtan.salesapp.salesapp.entity.LeaveType;

import java.util.List;

public interface LeaveTypeService {
    public void save (LeaveType lt);
    public void update (LeaveType lt);
    public void delete (LeaveType lt);


    public List<LeaveType> findAll();
}
