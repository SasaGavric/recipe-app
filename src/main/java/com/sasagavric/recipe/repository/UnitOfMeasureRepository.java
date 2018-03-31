package com.sasagavric.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sasagavric.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

	Optional<UnitOfMeasure> findByDescription(String description);
	
}
