package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface EmployeeTrainingDetailsCustomRepository {
    public List<EmployeeTrainingDetails> findByStatus(boolean status);

    public List<EmployeeTrainingDetails> finByEmployeeTraingId(Employee empid, EmployeeTraining emptraid);
}
