package com.newpro.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping(value="/updateStudent/{regno}")
	public Student updateStudent(@RequestBody Student s, @PathVariable int regno)
	{
		return studService.updateStudent(s,regno);
		
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
	
	@GetMapping(value="/sortStudent/{field}")
	public List<Student> sortStudents(@PathVariable String field)
	{
		return studService.sortStudents(field);
	}
	
	@GetMapping("/pagingStudents/{offset}/{pageSize}")
	public List<Student> pagingStudents(@PathVariable int offset, @PathVariable int pageSize)
	{
		return studService.pagingStudents(offset,pageSize);
	}
	
	@GetMapping("/pagingStudent/{offset}/{pageSize}")
	public Page<Student> pagingStudent(@PathVariable int offset, @PathVariable int pageSize)
	{
		return studService.pagingStudent(offset,pageSize);
	}
	
	@GetMapping("/pagingandsorting/{offset}/{pageSize}/{field}")
	public List<Student> pagingAndSortingStudents(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return studService.pagingAndSortingStudents(offset,pageSize,field);
	}
	
	//For RequestParam
	//http://localhost:9080/fetchStudentsByNamePrefix?prefix=a
	
	@GetMapping(value="/getByName")
	public List<Student> fetchByName(@RequestParam String name)
	{
		return studService.fetchByName(name);
	}
	
	@GetMapping(value="/getByNamePrefix")
	public List<Student> fetchByNamePrefix(@RequestParam String prefix)
	{
		return studService.fetchByNamePrefix(prefix);
	}
	
	@GetMapping(value="/getByNameSuffix")
	public List<Student> fetchByNameSuffix(@RequestParam String suffix)
	{
		return studService.fetchByNameSuffix(suffix);
	}
	
	@GetMapping(value="/getByDepartment")
	public List<Student> fetchByDepartment(@RequestParam String department)
	{
		return studService.fetchByDepartment(department);
	}
	
}
