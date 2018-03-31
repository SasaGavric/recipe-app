package com.sasagavric.recipe.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude={"recipes"})
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@ManyToMany
	@JoinTable(name="recipe_category",
	joinColumns=@JoinColumn(name="category_id"),
	inverseJoinColumns=@JoinColumn(name="recipe_id"))
	private Set<Recipe> recipes;

}
