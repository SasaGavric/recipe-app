package com.sasagavric.recipe.repository;

import org.springframework.data.repository.CrudRepository;

import com.sasagavric.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	

}
