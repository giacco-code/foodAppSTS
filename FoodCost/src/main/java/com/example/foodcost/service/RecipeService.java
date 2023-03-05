package com.example.foodcost.service;

import com.example.foodcost.entity.IngredientEntity;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.foodcost.entity.RecipeEntity;
import com.example.foodcost.repo.RecipeRepo;

import java.util.List;

@Component //todo better do it using a configuration class that initialize the beans
@Data
public class RecipeService {
    private final RecipeRepo recipeRepo;

    @PostMapping
    public void recipeName(String recipeName) {
        RecipeEntity recipeEntity = new RecipeEntity();
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName("Ingredient_1_name");
        ingredientEntity.setDescription("Ingredient_1_desc");
        ingredientEntity.setQty(100);
        recipeEntity.setIngredientEntities(List.of(ingredientEntity));
        recipeEntity.setRecipeName(recipeName);
        recipeRepo.save(recipeEntity);
    }
}
