package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.CivilStatus;
import com.vtan.salesapp.salesapp.entity.Department;

import java.util.List;

public interface CivilStatusService {
    public void save (CivilStatus c);
    public void update (CivilStatus c);
    public void delete (CivilStatus c);

    public List<CivilStatus> findAll();
}
