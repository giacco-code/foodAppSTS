package com.example.foodcost.controller;

import com.example.foodcost.controller.model.IngredientView;
import com.example.foodcost.controller.model.RecipeView;
import com.example.foodcost.service.RecipeServiceImpl;
import com.example.foodcost.service.model.Ingredient;
import com.example.foodcost.service.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1") // all api declared here will be with a /v1.... ex. /v1/{recipeName} etc
public class RecipeController implements RecipeApi {

    private final RecipeServiceImpl recipeService;

    @Override
    public void saveRecipe(@RequestBody RecipeView recipe) {
        recipeService.save(toDomain(recipe));
    }

    @Override
    public ResponseEntity<List<RecipeView>> getAll() {
        return ResponseEntity.ok(toView(recipeService.get()));
    }

    private Recipe toDomain(RecipeView recipeView) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeView.getName());
        if (recipeView.getIngredients() != null)
            recipeView.getIngredients().forEach(ingredient -> recipe.getIngredients().add(toDomain(ingredient)));
        return recipe;
    }

    private Ingredient toDomain(IngredientView ingredient) {
        return new Ingredient(ingredient.getName(), ingredient.getDescription(), ingredient.getQty());
    }

    private List<RecipeView> toView(List<Recipe> recipes) {
        List<RecipeView> recipeViewlist = new ArrayList<>();
        for (Recipe recipe : recipes) {
            recipeViewlist.add(convertFromRecipe(recipe));
        }
        return recipeViewlist;
    }

    private RecipeView convertFromRecipe(Recipe recipe) {
        RecipeView recipeView = new RecipeView();
        recipeView.setName(recipe.getName());
        if (recipe.getIngredients() != null)
            recipe.getIngredients().forEach(ingredient -> recipeView.getIngredients().add(toView(ingredient)));
        return recipeView;
    }

    private IngredientView toView(Ingredient ingredient) {
        IngredientView ingredientView = new IngredientView();
        ingredientView.setName(ingredient.getName());
        ingredientView.setDescription(ingredient.getDescription());
        ingredientView.setQty(ingredient.getQty());
        return ingredientView;
    }
}
