package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Department;
import com.vtan.salesapp.salesapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class DepartmentServiceimpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public void save(Department d) {
        departmentRepository.save(d);
    }

    @Override
    public void update(Department d) {
        departmentRepository.save(d);
    }

    @Override
    public void delete(Department d) {
        departmentRepository.delete(d);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.getOne(id);
    }
}
