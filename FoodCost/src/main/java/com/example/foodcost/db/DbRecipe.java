package com.example.foodcost.db;

import com.example.foodcost.service.model.Recipe;

import java.util.List;

public interface DbRecipe {
    void save(Recipe recipe);

    List<Recipe> findAll();
}
