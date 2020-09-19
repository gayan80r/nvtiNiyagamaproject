package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.OJTPlace;
import com.vtan.salesapp.salesapp.entity.OjtDetails;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.repository.OJTPlaceRepository;
import com.vtan.salesapp.salesapp.repository.OjtDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OjtDetailsServiceImpl implements OjtDetailsService{
    @Autowired
    private OjtDetailsRepository ojtDetailsRepository;
    @Override
    public void save(OjtDetails sb) {
       ojtDetailsRepository.save(sb);
    }

    @Override
    public void update(OjtDetails sb) {
        ojtDetailsRepository.save(sb);
    }

    @Override
    public void delete(OjtDetails sb) {
         ojtDetailsRepository.delete(sb);
    }

    @Override
    public OjtDetails findById(int id) {
        return ojtDetailsRepository.findById(id).get();
    }

    @Override
    public List<OjtDetails> findByStatus(boolean status) {
        return ojtDetailsRepository.findByStatus(status);
    }

    @Override
    public List<OjtDetails> findAll() {
        return ojtDetailsRepository.findAll();
    }

    @Override
    public List<OjtDetails> finByOjtDetailsId(RegistedStudent studentid, OJTPlace ojtid) {
        return ojtDetailsRepository.finByOjtDetailsId(studentid,ojtid);
    }
}
