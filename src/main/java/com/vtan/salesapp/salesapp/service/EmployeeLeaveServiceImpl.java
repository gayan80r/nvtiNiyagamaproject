package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.EmployeeLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {
    @Autowired
    private EmployeeLeaveService employeeLeaveService;
    @Override
    public void save(EmployeeLeave el) {
        employeeLeaveService.save(el);
    }

    @Override
    public void update(EmployeeLeave el) {
        employeeLeaveService.save(el);
    }

    @Override
    public void delete(EmployeeLeave el) {
        employeeLeaveService.delete(el);
    }

    @Override
    public EmployeeLeave findById(int id) {
        return employeeLeaveService.findById(id);
        //return  employeeLeaveService.findById(id).g

       // employeeRepository.findById(id).get()
    }

   /* @Override
    public EmployeeLeave findById(int id) {
        return employeeLeaveService.findById(id).get();
    }*/

   /* @Override
    public List<EmployeeLeave> getAllEmployeeLeave() {
        return null;
    }*/

    @Override
    public List<EmployeeLeave> findAll() {
        return employeeLeaveService.findAll();
    }

    @Override
    public List<EmployeeLeave> findByStatus(boolean status) {
        return employeeLeaveService.findByStatus(status);
    }

    @Override
    public List<EmployeeLeave> finByEmployeeStartEndDate(String epf_no, Date startdate, Date enddate) {
        return employeeLeaveService.finByEmployeeStartEndDate(epf_no, startdate, enddate);
    }
}
