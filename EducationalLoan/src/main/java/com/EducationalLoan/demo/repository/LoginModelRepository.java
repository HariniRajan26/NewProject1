package com.EducationalLoan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.EducationalLoan.demo.model.LoginModel;

@RestController
public interface LoginModelRepository extends JpaRepository<LoginModel,String>{

}
