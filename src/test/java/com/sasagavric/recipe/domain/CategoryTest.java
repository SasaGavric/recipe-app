package com.sasagavric.recipe.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	private Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() {
		Long longId = 4L;
		
		category.setId(longId);
		
		assertEquals(longId, category.getId());
	}

	@Test
	public void testGetDescription() {
		
	}

	@Test
	public void testGetRecipes() {
		
	}

}
