package com.example.foodcost.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.foodcost.entity.Recipe;
import com.example.foodcost.repo.RecipeRepo;

@Component //todo better do it using a configuration class that initialize the beans
@Data
public class RecipeService {

    private final Recipe recipe; //all attributes must be final, immutable objects

    private final RecipeRepo recipeRepo;

    @PostMapping
    public void recipeName(String recipeName) {
        recipe.setRecipeName(recipeName);
        recipeRepo.save(recipe);
    }
}
