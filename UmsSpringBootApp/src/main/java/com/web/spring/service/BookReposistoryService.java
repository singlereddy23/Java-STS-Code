package com.web.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.model.Book;
import com.web.spring.reposistory.BookReposistory;

@Service
public class BookReposistoryService
{
	@Autowired
	private BookReposistory repo;
	
	public Book findByName(String name)
	{
		return repo.findByName(name);
	}
	
	public List<Book> findByAuthorOrName(String author, String name)
	{
		return repo.findByAuthorOrName(author, name);
	}
	
	public List<Book> findByNameIgnoreCase(String name)
	{
		return repo.findByNameIgnoreCase(name);
	}
	
	@Transactional
	public void deleteByName(String name)
	{
		repo.deleteByName(name);
	}
}