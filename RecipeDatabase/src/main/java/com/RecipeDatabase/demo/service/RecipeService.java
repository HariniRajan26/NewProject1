package com.RecipeDatabase.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.RecipeDatabase.demo.dao.LoginRepository;
import com.RecipeDatabase.demo.dao.RecipeRepository;
import com.RecipeDatabase.demo.dao.RegistrationRepository;
import com.RecipeDatabase.demo.model.Login;
import com.RecipeDatabase.demo.model.Recipe;
import com.RecipeDatabase.demo.model.Registration;

@Service
public class RecipeService {

	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	RegistrationRepository regRepository;
	@Autowired
	LoginRepository loginRepository;
	
	public List<Recipe> getAllRecipe()
	{
		List <Recipe> studList=recipeRepository.findAll();
		return studList;
	}

	public Recipe saveRecipe(Recipe r) 
	{
		Recipe obj = recipeRepository.save(r);
		return obj;
	}
	
	public Recipe updateRecipe(Recipe r, @PathVariable int regno) 
	{
		return recipeRepository.save(r);
	}

	public void deleteRecipe(int recipeId) 
	{
		recipeRepository.deleteById(recipeId);
	}

	public Recipe getRecipe(int recipeId) 
	{
		return recipeRepository.findById(recipeId).get();
	}

	public List<Recipe> sortRecipe(String field) {
		
		return recipeRepository.findAll(Sort.by(field));
//		return recipeRepository.findAll(Sort.by(Direction.DESC,field));
	}
	
	public List<Recipe> pagingRecipes(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Recipe> recipeData=recipeRepository.findAll(paging);
		List<Recipe> recipeList=recipeData.getContent();//show the List of page
		return recipeList;
		
	}

	public Page<Recipe> pagingRecipe(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Recipe> recipeData=recipeRepository.findAll(paging);
		return recipeData;
	}
	
	public List<Recipe> pagingAndSortingRecipe(int offset,int pageSize,String field) 
	{
//		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Recipe> recipes=recipeRepository.findAll(paging);
		return recipes.getContent();
	}
	
	
	
	
	
	//For Login
	public List<Login> getLogin() 
	{
		return loginRepository.findAll();
	}
	
	public Login saveLogin(Login l)
	{
		return loginRepository.save(l); 
	}
	
	public String validateUserLogin(String username,String password)
	{
//		String result="";
		Login l=loginRepository.findByUsername(username);
		if(l==null)
		{
			return "Invalid user";
		}
		else
		{
			if(l.getPassword().equals(password))
			{
				return "Login success";
			}
			else
			{
				return "Login failed";
			}
		}
//		return "Invalid";
	}
	
	
	
	//For registration
	public List<Registration> getReg() 
	{
		List<Registration> regList = regRepository.findAll();
		return regList;
	}

	public Registration saveReg(Registration r) 
	{
		return regRepository.save(r);
	}
	
    public List<Registration> sortReg(String field) {
		
		return regRepository.findAll(Sort.by(field));
//		return regRepository.findAll(Sort.by(Direction.DESC,field));
	}
	
	public List<Registration> pagingRegs(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Registration> regData=regRepository.findAll(paging);
		List<Registration> regList=regData.getContent();//show the List of page
		return regList;
		
	}

	public Page<Registration> pagingReg(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Registration> regData=regRepository.findAll(paging);
		return regData;
	}
	
	public List<Registration> pagingAndSortingReg(int offset,int pageSize,String field) 
	{
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Registration> recipes=regRepository.findAll(paging);
		return recipes.getContent();
	}
}
