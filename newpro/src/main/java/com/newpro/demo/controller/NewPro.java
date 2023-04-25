package com.newpro.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewPro {

	@GetMapping("/login")
	public String Login()
	{
		return "Successfully Logged-In";
	}
	
	@GetMapping("/landing/{name}")
	public String landing(@PathVariable("name") String name)
	{
		return "Hii... "+name+" (^^__^^) ";
	}
	
}
