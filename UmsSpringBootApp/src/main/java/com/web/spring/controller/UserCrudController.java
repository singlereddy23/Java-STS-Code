package com.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.model.User;
import com.web.spring.service.UserCrudService;

@RestController
@RequestMapping("crudapi")
public class UserCrudController
{
	@Autowired
	private UserCrudService service;
	
	@GetMapping(value = "/users", produces = {"application/json"})	//crudapi/users
	public List<User> listUsers()
	{
		return service.listUsers();
	}
	
	@PostMapping(value = "/users", produces = {"application/json"}, consumes = {"application/json"})		//crudapi/users
	  public User saveUsers(@RequestBody User user)
	  { 
		User savedUser = service.saveUsers(user);
		  return savedUser; 
	  }
	  
	  @GetMapping(value = "/users/{id}", produces = {"application/json"})		//crudapi/users/101
	  public User findOne(@PathVariable Integer id)
	  { 
		  return service.findOne(id);
	  }
}