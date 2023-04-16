package com.web.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.model.User;
import com.web.spring.reposistory.UserCrudReposistory;

@Service
public class UserCrudService
{
	@Autowired
	private UserCrudReposistory repo;
	
	public List<User> listUsers()
	{
		return (List<User>) repo.findAll();
	}
	
	public User saveUsers(User user)
	{
		User savedUser = repo.save(user);
		return savedUser;
	}
	
	public User findOne(Integer id)
	{
		User user = repo.findById(id).get();
		return user;
	}
}