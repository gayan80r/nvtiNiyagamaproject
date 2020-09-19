package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Parrent;

import java.util.List;

public interface ParrentCustomRepository {
    public Parrent findByNameWithInitial(String name);
    public List<Parrent> findByStatus(boolean status);
    public Parrent findByemail(String email);
    public Parrent findByNic(String nic);
}
