package com.web.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.spring.model.User;

@Service
public class UserService
{
	public static List<User> users =  new ArrayList<>();
	static {
		users.add(new User(101, "KAMAL", "SR23RK@GMAIL.COM"));
		users.add(new User(102, "REDDY", "REDDYKAMAL97@GMAIL.COM"));
	}
	
	public List<User> getUsers()
	{	return users;
	}
	
	public void saveUser (User user)
	{	users.add(user);
	}
}