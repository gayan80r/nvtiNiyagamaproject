package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.*;

import java.util.List;

public interface OjtDetailsCustomRepository {
    public List<OjtDetails> findByStatus(boolean status);

    public List<OjtDetails> finByOjtDetailsId( RegistedStudent studentid,OJTPlace ojtid);
}
