package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface OjtDetailsService {
    public void save (OjtDetails sb);
    public void update (OjtDetails sb);
    public void delete (OjtDetails sb);
    public OjtDetails  findById(int id);

    public List<OjtDetails > findByStatus(boolean status);
    public List<OjtDetails > findAll();
    public List<OjtDetails>  finByOjtDetailsId(RegistedStudent studentid, OJTPlace ojtid);

}
