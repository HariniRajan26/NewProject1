package com.RecipeDatabase.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RecipeDatabase.demo.model.Login;
import com.RecipeDatabase.demo.model.Recipe;
import com.RecipeDatabase.demo.model.Registration;
import com.RecipeDatabase.demo.service.RecipeService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	
	@Tag(name= "Get", description="get data")
	@GetMapping(value="/fetchRecipe")
	public List<Recipe> getAllRecipe()
	{
		List<Recipe> studList=recipeService.getAllRecipe();
		return studList;
	}
	//http://localhost:9080/saveStudent
	
	@Tag(name= "Post", description="post data")
	@PostMapping(value="/saveRecipe")
	public Recipe saveRecipe(@RequestBody Recipe r)
	{
		return recipeService.saveRecipe(r);
		
	}
	
	@Tag(name= "Put", description="update data")
	@PutMapping(value="/updateRecipe/{regno}")
	public Recipe updateRecipe(@RequestBody Recipe r, @PathVariable int recipeId)
	{
		return recipeService.updateRecipe(r,recipeId);
		
	}
	
	@Tag(name= "Delete", description="delete Recipe")
	@DeleteMapping("/deleteRecipe/{recipeId}")
	public void deleteRecipe(@PathVariable("recipeId") int recipeId)
	{
		recipeService.deleteRecipe(recipeId);
		
	}
	
	@GetMapping(value="/sortRecipe/{field}")
	public List<Recipe> sortRecipe(@PathVariable String field)
	{
		return recipeService.sortRecipe(field);
	}

	
	@GetMapping("/pagingRecipes/{offset}/{pageSize}")
	public List<Recipe> pagingRecipes(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingRecipes(offset,pageSize);
	}
	
	@GetMapping("/pagingRecipe/{offset}/{pageSize}")
	public Page<Recipe> pagingRecipe(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingRecipe(offset,pageSize);
	}
	
	@GetMapping("/pagingAndSorting/{offset}/{pageSize}/{field}")
	public List<Recipe> pagingAndSortingRecipe(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return recipeService.pagingAndSortingRecipe(offset,pageSize,field);
	}
	
	


	
	
	
	
	
	
	//For Login
	@GetMapping(value="/getLogin")
	public List<Login> getLogin()
	{
		return recipeService.getLogin();
	}
	
	@PostMapping(value="/addUserLogin")
	public Login saveLogin(@RequestBody Login l)
	{
		return recipeService.saveLogin(l);
	}
	
	@PostMapping(value="/checkLogin")
	public String validateUserLogin(@RequestBody Login l)
	{
		System.out.println(l.getUsername());
		return recipeService.validateUserLogin(l.getUsername(),l.getPassword());
	}
	
	
	
	
	
	//For Registration
	@GetMapping(value="/getReg")
	public List<Registration> getReg()
	{
		List<Registration> regList = recipeService.getReg();
		return regList;
	}
	
	@PostMapping(value="/addUserReg")
	public Registration saveReg(@RequestBody Registration r)
	{
		return recipeService.saveReg(r);
	}
	
	@GetMapping("/pagingRegs/{offset}/{pageSize}")
	public List<Registration> pagingRegs(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingRegs(offset,pageSize);
	}
	
	@GetMapping("/pagingReg/{offset}/{pageSize}")
	public Page<Registration> pagingReg(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingReg(offset,pageSize);
	}
	
	@GetMapping("/pagingAndSortingReg/{offset}/{pageSize}/{field}")
	public List<Registration> pagingAndSortingReg(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return recipeService.pagingAndSortingReg(offset,pageSize,field);
	}
	
	

	
	
}
