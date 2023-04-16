package com.web.spring.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.spring.cloud.bean.CurrencyConversion;

//@FeignClient(name = "currency-exchange",url = "localhost:8000")
@FeignClient(name = "currency-exchange")//use in case of load balancing
public interface CurrencyExchangeProxy {
	
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(@PathVariable String from, @PathVariable String to);
		
	
}
