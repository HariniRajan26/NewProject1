package com.EducationalLoan.demo.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.EducationalLoan.demo.model.LoginModel;
import com.EducationalLoan.demo.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	public UserModel findByEmail(String email);
}
