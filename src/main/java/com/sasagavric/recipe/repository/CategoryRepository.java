package com.sasagavric.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sasagavric.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
	
	
}
