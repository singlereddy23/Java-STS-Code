package com.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.model.Book;
import com.web.spring.service.BookReposistoryService;

@RestController
@RequestMapping("repo")
public class BookReposistoryController
{
	@Autowired
	private BookReposistoryService service;
	
	@GetMapping(value = "findbyname")
	public Book findByName(String name)
	{
		return service.findByName(name);
	}
	
	@GetMapping(value = "findbyauthor")
	public List<Book> findByAuthorOrName(@RequestParam String author, @RequestParam String name)
	{
		return service.findByAuthorOrName(author, name);
	}
	
	@GetMapping(value = "findbyNameignorecase")
	public List<Book> findByNameIgnoreCase(@RequestParam String name)
	{
		return service.findByNameIgnoreCase(name);
	}
	
	@DeleteMapping(value = "delete")
	public void deleteByName(@RequestParam String name)
	{
		service.deleteByName(name);
	}
}
