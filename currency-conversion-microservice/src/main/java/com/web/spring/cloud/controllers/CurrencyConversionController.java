package com.web.spring.cloud.controllers;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.web.spring.cloud.bean.CurrencyConversion;
import com.web.spring.cloud.client.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	@Autowired
	Environment env;
	@Autowired
	private CurrencyExchangeProxy client;
	
	/*
	 * //http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	 * 
	 * @GetMapping(value =
	 * "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}") public
	 * CurrencyConversion calculateCurrencyConversion(@PathVariable String
	 * from, @PathVariable String to, @PathVariable BigDecimal quantity) { String
	 * port = env.getProperty("local.server.port"); CurrencyConversion conversion =
	 * new CurrencyConversion(1001L, from, to, quantity, BigDecimal.ONE,
	 * BigDecimal.ONE, port); return conversion; }
	 */
	
	
	@GetMapping(value = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		HashMap<String, String> uriVaribles = new HashMap<>();
		uriVaribles.put("from", from);
		uriVaribles.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVaribles);
		CurrencyConversion conversion = responseEntity.getBody();
		return new CurrencyConversion(1000L,from,to,quantity,conversion.getConversionMultiple(),quantity.multiply(conversion.getConversionMultiple()),conversion.getEnv());
	}
	
	
	
	@GetMapping(value = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionfeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversion conversion = client.retriveExchangeValue(from, to);
		return new CurrencyConversion(1000L,from,to,quantity,conversion.getConversionMultiple(),quantity.multiply(conversion.getConversionMultiple()),conversion.getEnv());
	}
	
}
