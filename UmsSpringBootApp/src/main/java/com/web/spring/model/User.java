package com.web.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "udetails")
public class User
{
	@Id
	@Column(name = "UDID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	
	public int getId()
	{	return id;
	}
	public void setId(int id)
	{	this.id = id;
	}
	public String getName()
	{	return name;
	}
	public void setName(String name)
	{	this.name = name;
	}
	public String getEmail()
	{	return email;
	}
	public void setEmail(String email)
	{	this.email = email;
	}
	
	public User(int id, String name, String email)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}