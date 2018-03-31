package com.sasagavric.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sasagavric.recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private final RecipeService recipeService;
		
	@Autowired
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		log.debug("controller for home");
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
	}
	
}