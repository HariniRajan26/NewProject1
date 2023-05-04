package com.newpro.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	List<Student> findByName(String name);
	List<Student> findByNameStartingWith(String prefix);
	List<Student> findByNameEndingWith(String suffix);
	List<Student> findByDepartment(String department);
	
	@Modifying
	@Query("delete  from Student s where s.name=?1" )
	public int deleteStudentByName(String name);
	
	@Modifying
	@Query("update Student s set s.department=?1 where s.name=?2")
	public int updateStudentsByName(String department,String name);
	
	@Query(value="select * from Student  s where  s.email= ?1", nativeQuery=true)
	public List<Student> fetchStudentByMail(String email);
	
}
