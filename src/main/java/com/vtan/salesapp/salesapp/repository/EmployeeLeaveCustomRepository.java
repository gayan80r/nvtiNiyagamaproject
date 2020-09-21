package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.EmployeeLeave;

import java.util.List;

public interface EmployeeLeaveCustomRepository {
    public List<EmployeeLeave> findByStatus(boolean status);

    public List<EmployeeLeave> finByEmployeeStartEndDate(EmployeeLeave epf_no,EmployeeLeave startdate,EmployeeLeave enddate);
}
