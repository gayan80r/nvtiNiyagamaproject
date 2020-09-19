package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Trade;

import java.util.List;

public interface TradeService {
    public void save (Trade t);
    public void update (Trade t);
    public void delete (Trade t);


    public List<Trade> findAll();
}
