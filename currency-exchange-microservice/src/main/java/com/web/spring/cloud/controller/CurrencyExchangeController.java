package com.web.spring.cloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.web.spring.cloud.bean.CurrencyExchange;
import com.web.spring.cloud.repo.CurrencyExchangeReposistory;

@RestController
public class CurrencyExchangeController {
	@Autowired
	Environment env;
	@Autowired
	private CurrencyExchangeReposistory repo;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	/*
	 * @GetMapping(value = "/currency-exchange/from/{from}/to/{to}") public
	 * CurrencyExchange retriveExchangeValue(@PathVariable String
	 * from, @PathVariable String to) {
	 * //http://localhost:8000/currency-exchange/from/USD/to/INR CurrencyExchange
	 * currencyExchange = new
	 * CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50)); String port =
	 * env.getProperty("local.server.port"); currencyExchange.setEnv(port); return
	 * currencyExchange; }
	 */
	
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		String port = env.getProperty("local.server.port");
		currencyExchange.setEnv(port);
		logger.info("Inside Currency Exchange"+from+""+to);
		return currencyExchange;
	}
	
}
