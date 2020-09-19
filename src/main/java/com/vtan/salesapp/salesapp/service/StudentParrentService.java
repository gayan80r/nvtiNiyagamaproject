package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Parrent;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentParrent;

import java.util.List;

public interface StudentParrentService {
    public void save (StudentParrent sp);
    public void update (StudentParrent sp);
    public void delete (StudentParrent sp);
    public StudentParrent   findById(int id);

    public List<StudentParrent  > findByStatus(boolean status);
    public List<StudentParrent  > findAll();
    public List<StudentParrent >  finByStundentParrendId(Parrent parrentId, RegistedStudent studentId);
}
