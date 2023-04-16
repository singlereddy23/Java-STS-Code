package com.web.spring.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.spring.cloud.bean.CurrencyExchange;
@Repository
public interface CurrencyExchangeReposistory extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
	
}
