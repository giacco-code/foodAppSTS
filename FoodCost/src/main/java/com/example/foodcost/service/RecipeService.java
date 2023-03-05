package com.example.foodcost.service;

import com.example.foodcost.service.model.Recipe;

import java.util.List;

public interface RecipeService {
    void save(Recipe recipe);

    List<Recipe> get();
}
