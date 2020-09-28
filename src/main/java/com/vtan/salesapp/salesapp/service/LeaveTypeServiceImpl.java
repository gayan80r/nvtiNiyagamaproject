package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.LeaveType;
import com.vtan.salesapp.salesapp.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;
    @Override
    public void save(LeaveType lt) {
        leaveTypeRepository.save(lt);
    }

    @Override
    public void update(LeaveType lt) {
        leaveTypeRepository.save(lt);
    }

    @Override
    public void delete(LeaveType lt) {
        leaveTypeRepository.delete(lt);
    }

    @Override
    public List<LeaveType> findAll() {
        return leaveTypeRepository.findAll();
    }
}
