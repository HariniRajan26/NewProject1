package com.RecipeDatabase.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

@Entity
public class Recipe {

	@Id
	private int recipeId;
	private int categoryId;
	private String recipeName;
	private String description;
	private String cuisine;
	private int prepTime;
	private int serving;
//	@ManyToOne
//	@JoinColumn
//	private Registration userId;
	
	public Recipe() {
		super();
	}
	
	
	
	public Recipe(int recipeId, int categoryId, String recipeName, String description, String cuisine, int prepTime,
		int serving) {
	super();
	this.recipeId = recipeId;
	this.categoryId = categoryId;
	this.recipeName = recipeName;
	this.description = description;
	this.cuisine = cuisine;
	this.prepTime = prepTime;
	this.serving = serving;
}



	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
//	public Registration getUserId() {
//		return userId;
//	}
//	public void setUserId(Registration userId) {
//		this.userId = userId;
//	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	public int getServing() {
		return serving;
	}
	public void setServing(int serving) {
		this.serving = serving;
	}
	
	
}
