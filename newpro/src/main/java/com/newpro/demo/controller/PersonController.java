package com.newpro.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newpro.demo.dao.Person;
import com.newpro.demo.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("getAllPersons")
	public List<Person> fetchAllPersons()
	{
		return personService.fetchAllPersons();
	}
	
	@PostMapping("/savePersons")
	public Person savePersons(@RequestBody Person p)
	{
		return personService.savePersons(p);
	}
}
