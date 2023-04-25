package com.newpro.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newpro.demo.dao.Student;
import com.newpro.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studService;
	
	@GetMapping(value="/fetchStudents")
	public List<Student> getAllStudents()
	{
		List<Student> studList=studService.getAllStudents();
		return studList;
	}
	//http://localhost:9080/saveStudent
	
	@PostMapping(value="/saveStudent")
	public Student saveStudent(@RequestBody Student s)
	{
		return studService.saveStudent(s);
		
	}
	
	@PutMapping(value="/updateStudent")
	public Student updateStudent(@RequestBody Student s)
	{
		return studService.updateStudent(s);
		
	}
	
	@DeleteMapping("/deleteStudent/{regno}")
	public void deleteStudent(@PathVariable("regno") int regno)
	{
		studService.deleteStudent(regno);
		
	}
	
	@GetMapping(value="/getStudent/{regno}")
	public Student getStudent(@PathVariable("regno") int regno)
	{
		return studService.getStudent(regno);
		
	}
}
