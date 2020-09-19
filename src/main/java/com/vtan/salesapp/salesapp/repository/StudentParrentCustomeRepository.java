package com.vtan.salesapp.salesapp.repository;



import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface StudentParrentCustomeRepository {
    public List<StudentParrent> findByStatus(boolean status);

    public List<StudentParrent> finByStundentParrendId(Parrent parrentId, RegistedStudent studentId);
}
