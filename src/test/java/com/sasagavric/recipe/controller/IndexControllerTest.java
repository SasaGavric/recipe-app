package com.sasagavric.recipe.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import com.sasagavric.recipe.domain.Recipe;
import com.sasagavric.recipe.service.RecipeService;

public class IndexControllerTest {
	
	IndexController indexController;
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		indexController = new IndexController(recipeService);		
	}
	
	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}

	@Test
	public void testGetIndexPage() {		
		
		//given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		
		Recipe theRecipe = new Recipe();
		theRecipe.setId(2L);
		recipes.add(theRecipe);
		
		//when
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		@SuppressWarnings("unchecked")
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		assertEquals("index", indexController.getIndexPage(model));
		
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		verify(recipeService, times(1)).getRecipes();
		
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}
