package com.requestparam.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

	@GetMapping("/getpost")
	public String getRequest(@RequestParam String name,@RequestParam String password)
	{
		if(name.equals("Harini")&&password.equals("2323"))
		{
			return "Successfully Logged In";
		}
		else
		{
			return "Failed";
		}
	}
}
