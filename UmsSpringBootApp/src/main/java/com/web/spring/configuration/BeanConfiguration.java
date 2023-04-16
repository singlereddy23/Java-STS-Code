package com.web.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class BeanConfiguration
{
	public InternalResourceViewResolver setupResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INFO/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}