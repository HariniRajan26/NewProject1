package com.newpro.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;

import com.newpro.demo.dao.Student;
import com.newpro.demo.dao.StudentRepository;

import jakarta.transaction.Transactional;

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
	
//	public Student updateStudent(Student s, @PathVariable int regno) 
//	{
//		return studRepository.save(s);
//	}

	public void deleteStudent(int regno) 
	{
		studRepository.deleteById(regno);
	}

	public Student getStudent(int regno) 
	{
		return studRepository.findById(regno).get();
	}

	public List<Student> sortStudents(String field) {
		
//		return studRepository.findAll(Sort.by(field));
		return studRepository.findAll(Sort.by(Direction.DESC,field));
	}
	
	public Student updateStudent(Student s, int regno) 
	{
		Optional<Student> optional=studRepository.findById(regno);
		Student obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setRegno(s.getRegno());
			obj.setName(s.getName());
			obj.setDepartment(s.getDepartment());
			obj.setEmail(s.getEmail());
			studRepository.saveAndFlush(s);
		}
		return obj;
	}

	public List<Student> pagingStudents(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Student> studData=studRepository.findAll(paging);
		List<Student> studList=studData.getContent();//show the List of page
		return studList;
		
	}

	public Page<Student> pagingStudent(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Student> studData=studRepository.findAll(paging);
//		List<Student> studList=studData.getContent();//show the List of page
		return studData;
	}
	
	public List<Student> pagingAndSortingStudents(int offset,int pageSize,String field) 
	{
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Student> stud=studRepository.findAll(paging);
		return stud.getContent();
	}
// CRUD>> Pagenation>> JpaRepository

	public List<Student> fetchByName(String name) 
	{
		return studRepository.findByName(name);
	}
	
	public List<Student> fetchByNamePrefix(String prefix) 
	{
		return studRepository.findByNameStartingWith(prefix);
	}

	public List<Student> fetchByNameSuffix(String suffix) 
	{
		return studRepository.findByNameEndingWith(suffix);
	}

	public List<Student> fetchByDepartment(String department) 
	{
		return studRepository.findByDepartment(department);
	}

	
	
	
	//Query
	@Transactional
	public int deleteStudentByName(String name)
	{
		return studRepository.deleteStudentByName(name);
	}
	
	@Transactional
	public int updateStudentByName(String department, String name)
	{
		return studRepository.updateStudentsByName(department,name);
	}


	public List<Student> fetchStudentByMail(String email) 
	{
		return studRepository.fetchStudentByMail(email);
	}
	
	
	
}
