package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.EmployeeLeave;

import java.util.List;

public interface EmployeeLeaveService {
    public void save (EmployeeLeave el);
    public void update (EmployeeLeave el);
    public void delete (EmployeeLeave el);

   // public EmployeeLeave findById(int id);



    //public List<EmployeeLeave> getAllEmployeeLeave();

    public List<EmployeeLeave > findAll();
    public List<EmployeeLeave> findByStatus(boolean status);
    public List<EmployeeLeave> finByEmployeeStartEndDate(EmployeeLeave epf_no, EmployeeLeave startdate, EmployeeLeave enddate);

}
