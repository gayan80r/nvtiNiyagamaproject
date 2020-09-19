package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.OJTPlace;

import java.util.List;

public interface OJTPlaceCustomRepository {
    public OJTPlace findByName(String name);
    public OJTPlace findByEmail(String email);
    public List<OJTPlace> findByStatus(boolean status);
}
