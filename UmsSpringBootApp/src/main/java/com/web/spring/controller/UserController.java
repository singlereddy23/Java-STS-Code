package com.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.model.User;
import com.web.spring.service.UserService;

@RestController
@RequestMapping(value = "userapi")	
public class UserController
{
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/greet")		// http://localhost:8082/userapi/greet
	public String greet()
	{
		return "Welcome To User Management API";
	}
	
	@GetMapping(value = "/users", produces = {"application/json"})		// http://localhost:8082/userapi/users
	public User getUser()
	{
		return new User(101, "KAMAL", "SR23RK@GMAIL.COM");
	}
	
	@GetMapping(value = "/listusers", produces = {"application/json","application/xml"})	// http://localhost:8082/userapi/listusers
	public List<User> listUser()
	{
		return service.getUsers();
	}
	
	@PostMapping(value = "/users", produces = {"application/json"},consumes= {"application/json"})	// http://localhost:8082/userapi/users
	public User savetUsers(@RequestBody User user)
	{
		service.saveUser(user);
		return user;
	}
}