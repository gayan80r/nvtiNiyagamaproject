package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.highestEducationalQualification;
import com.vtan.salesapp.salesapp.entity.highestVocationalQualification;
import com.vtan.salesapp.salesapp.repository.HighestVocationalQualificationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HighestVocationalQualificationServiceimpl implements HighestVocationalQualificationService {
    @Autowired
    private HighestVocationalQualificationalRepository highestvocationalqualificationalrepository;

    @Override
    public void save(highestVocationalQualification q) {
        highestvocationalqualificationalrepository.save(q);
    }

    @Override
    public void update(highestVocationalQualification q) {
        highestvocationalqualificationalrepository.save(q);
    }

    @Override
    public void delete(highestVocationalQualification q) {
        highestvocationalqualificationalrepository.delete(q);
    }

    @Override
    public List<highestVocationalQualification> findAll() {
        return highestvocationalqualificationalrepository.findAll();
    }


}
