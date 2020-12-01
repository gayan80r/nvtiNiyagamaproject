package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.highestEducationalQualification;
import com.vtan.salesapp.salesapp.repository.HighestEducationalQualificationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HighestEducationalQualificationServiceimpl implements HighestEducationalQualificationService {
    @Autowired//we add the dependancy injection
    private HighestEducationalQualificationalRepository highesteducationalqualificationalrepository;
    @Override
    public void save(highestEducationalQualification q) {
        highesteducationalqualificationalrepository.save(q);
    }

    @Override
    public void update(highestEducationalQualification q) {
        highesteducationalqualificationalrepository.save(q);
    }

    @Override
    public void delete(highestEducationalQualification q) {
        highesteducationalqualificationalrepository.delete(q);
    }

    @Override
    public List<highestEducationalQualification> findAll() {
      return highesteducationalqualificationalrepository.findAll();}

    @Override
    public highestEducationalQualification findById(int id) {
        return highesteducationalqualificationalrepository.getOne(id);
    }
}
