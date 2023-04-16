package com.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("emp")
public class SpringMVCController
{
	@GetMapping(value = "/greet")		// http://localhost:8082/emp/greet
	public ModelAndView greet ()
	{
		return new ModelAndView("greeting", "msg", "Spring MVC APP using Spring Boot");
	}
}