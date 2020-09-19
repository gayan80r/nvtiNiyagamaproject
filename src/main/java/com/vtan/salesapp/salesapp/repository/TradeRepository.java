package com.vtan.salesapp.salesapp.repository;

import com.vtan.salesapp.salesapp.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade,Integer> {
}
