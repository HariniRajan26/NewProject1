package com.FilmIndustry.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FilmIndustry.demo.dao.Film;
import com.FilmIndustry.demo.service.FilmService;

@RestController
public class FilmController {

	@Autowired
	FilmService filmService;
	
	@GetMapping(value="/fetchDetails")
	public List<Film> getAllDetails()
	{
		List<Film> filmList=filmService.getAllDetails();
		return filmList;
	}
	//http://localhost:9080/saveStudent
	
	@PostMapping(value="/saveDetails")
	public Film saveDetails(@RequestBody Film f)
	{
		return filmService.saveDetails(f);
		
	}
	
	@PutMapping(value="/updateDetails")
	public Film updateDetails(@RequestBody Film f)
	{
		return filmService.updateDetails(f);
		
	}
	
	@DeleteMapping("/deleteDetails/{filmid}")
	public void deleteDetails(@PathVariable("filmid") int filmid)
	{
		filmService.deleteDetails(filmid);
		
	}
	

}
