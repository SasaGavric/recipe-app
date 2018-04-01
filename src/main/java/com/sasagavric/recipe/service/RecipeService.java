package com.sasagavric.recipe.service;

import java.util.Set;

import com.sasagavric.recipe.domain.Recipe;

public interface RecipeService {
	
	Set<Recipe> getRecipes();

	Recipe findById(long id);

}
