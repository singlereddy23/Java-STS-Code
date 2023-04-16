package com.web.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookinfo")
public class Book
{
	@Id
	@Column(name = "b_Id")
	Integer bookId;
	String name;
	String author;
	Integer price;
	
	public Book(Integer bookId, String name, String author, Integer price)
	{
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Book()
	{
		
	}

	public Integer getBookId()
	{
		return bookId;
	}
	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public Integer getPrice()
	{
		return price;
	}
	public void setPrice(Integer price)
	{
		this.price = price;
	}
}