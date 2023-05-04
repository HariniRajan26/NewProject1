package com.RecipeDatabase.demo.model;

//import java.util.List;
//
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;

@Entity
public class Ingredients {

	@Id
	private int id;
	private String IngredientName;
	private float quantity;
	private String type;
	private String unit;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "recipeId")
// 	private List<Recipe> recipe;
	
	
//	public String getRecipeName() {
//		return recipeName;
//	}
//	public void setRecipeName(String recipeName) {
//		this.recipeName = recipeName;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	public int getIngredientId() {
//		return IngredientId;
//	}
//	public void setIngredientId(int ingredientId) {
//		IngredientId = ingredientId;
//	}
	public String getIngredientName() {
		return IngredientName;
	}
	public void setIngredientName(String ingredientName) {
		IngredientName = ingredientName;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
//	public List<Recipe> getRecipe() {
//		return recipe;
//	}
//	public void setRecipe(List<Recipe> recipe) {
//		this.recipe = recipe;
//	}
	
	
	
}
