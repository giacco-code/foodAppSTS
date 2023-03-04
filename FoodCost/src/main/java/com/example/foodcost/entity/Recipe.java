package com.example.foodcost.entity;

import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recipe {
	  @Id
	  private String recipeName;
	  
	  private String[] ingredients;
	
	  private Integer[] qty;

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	public Integer[] getQty() {
		return qty;
	}

	public void setQty(Integer[] qty) {
		this.qty = qty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + Arrays.hashCode(qty);
		result = prime * result + Objects.hash(recipeName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		return Arrays.equals(ingredients, other.ingredients) && Arrays.equals(qty, other.qty)
				&& Objects.equals(recipeName, other.recipeName);
	}

	public Recipe(String recipeName, String[] ingredients, Integer[] qty) {
		super();
		this.recipeName = recipeName;
		this.ingredients = ingredients;
		this.qty = qty;
	}

	public Recipe(String recipeName) {
		super();
		this.recipeName = recipeName;

	}
	  
	  
	  
	  
}