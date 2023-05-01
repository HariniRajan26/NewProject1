package com.RecipeDatabase.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RecipeDatabase.demo.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

	
}
