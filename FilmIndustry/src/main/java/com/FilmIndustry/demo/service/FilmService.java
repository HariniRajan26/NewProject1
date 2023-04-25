package com.FilmIndustry.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FilmIndustry.demo.dao.Film;
import com.FilmIndustry.demo.dao.FilmRepository;

@Service
public class FilmService {

	@Autowired
	FilmRepository filmRepository;
	
	public List<Film> getAllDetails()
	{
		List <Film> filmList=filmRepository.findAll();
		return filmList;
	}

	public Film saveDetails(Film f) 
	{
		return filmRepository.save(f);
		
	}
	
	public Film updateDetails(Film f) 
	{
		return filmRepository.save(f);
	}

	public void deleteDetails(int filmid) 
	{
		filmRepository.deleteById(filmid);
	}



}
