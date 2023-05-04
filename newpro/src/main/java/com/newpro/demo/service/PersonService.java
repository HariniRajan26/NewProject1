package com.newpro.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newpro.demo.dao.Person;
import com.newpro.demo.dao.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;
	
	public List<Person> fetchAllPersons()
	{
		return personRepo.findAll();
	}

	public Person savePersons(Person p) 
	{
		return personRepo.save(p);
	}
	
}
