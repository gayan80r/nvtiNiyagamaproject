package com.vtan.salesapp.salesapp.service;

import com.vtan.salesapp.salesapp.entity.Trade;
import com.vtan.salesapp.salesapp.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private  TradeRepository tradeRepository;
    @Override


    public void save(Trade t) {
        tradeRepository.save(t);
    }

    @Override
    public void update(Trade t) {
        tradeRepository.save(t);
    }

    @Override
    public void delete(Trade t) {
      tradeRepository.delete(t);
    }

    @Override
    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }
}
