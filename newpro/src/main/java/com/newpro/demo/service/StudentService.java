package com.newpro.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newpro.demo.dao.Student;
import com.newpro.demo.dao.StudentRepository;

//import com.newpro.demo.controller.StudentService;

@Service
public class StudentService {

//	StudentService studService=new StudentService();
	@Autowired
	StudentRepository studRepository;
	
	public List<Student> getAllStudents()
	{
		List <Student> studList=studRepository.findAll();
		return studList;
	}

	public Student saveStudent(Student s) 
	{
		Student obj = studRepository.save(s);
		return obj;
		//return studRepository.save(s);	
	}
	
	public Student updateStudent(Student s) 
	{
		return studRepository.save(s);
	}

	public void deleteStudent(int regno) 
	{
		studRepository.deleteById(regno);
	}

	public Student getStudent(int regno) 
	{
		return studRepository.findById(regno).get();
	}
//	public Student getStudent(int regno) {
//		Student s=studRepository.findById(regno).get();
//		return s;
//		
//	}
}
