package com.example.foodcost.db;

import java.util.ArrayList;

import com.example.foodcost.db.entity.IngredientEntity;
import com.example.foodcost.db.entity.RecipeEntity;
import com.example.foodcost.db.repo.IngredientRepository;
import com.example.foodcost.db.repo.RecipeRepository;
import com.example.foodcost.service.model.Ingredient;
import com.example.foodcost.service.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
public class DbRecipeImpl implements DbRecipe{
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepo;

    @Override
    public void save(Recipe recipe) {
        RecipeEntity entity = ToEntity(recipe);
        ingredientRepo.saveAll(entity.getIngredientEntities());
        recipeRepository.save(entity);
    }

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeEntity> recipeEntities = recipeRepository.findAll();
        for (RecipeEntity recipeEntity : recipeEntities) {
            recipes.add(convertFromRecipeEntity(recipeEntity));
        }
        return recipes;
    }

    private Recipe convertFromRecipeEntity(RecipeEntity recipeEntity) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeEntity.getName());
        recipe.setIngredients(toDomain(recipeEntity.getIngredientEntities()));
        return recipe;
    }

    private List<Ingredient> toDomain(List<IngredientEntity> ingredientEntities) {
        List<Ingredient> ingredientlist = new ArrayList<>();
        for (IngredientEntity ingredientEntity : ingredientEntities) {
            ingredientlist.add(convertFromIngredientEntity(ingredientEntity));
        }
        return ingredientlist;
    }

    private Ingredient convertFromIngredientEntity(IngredientEntity ingredientEntity) {
        return new Ingredient(ingredientEntity.getName(), ingredientEntity.getDescription(), ingredientEntity.getQty());
    }

    private RecipeEntity ToEntity(Recipe recipe) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(UUID.randomUUID().toString());
        recipeEntity.setName(recipe.getName());
        recipeEntity.setIngredientEntities(toEntity(recipe.getIngredients()));
        return recipeEntity;

    }

    private List<IngredientEntity> toEntity(List<Ingredient> ingredientEntities) {
        List<IngredientEntity> ingredientEntitylist = new ArrayList<>();
        for (Ingredient ingredient : ingredientEntities) {
            ingredientEntitylist.add(convertFromIngredient(ingredient));
        }
        return ingredientEntitylist;
    }

    private IngredientEntity convertFromIngredient(Ingredient ingredient) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(UUID.randomUUID().toString());
        ingredientEntity.setName(ingredient.getName());
        ingredientEntity.setDescription(ingredient.getDescription());
        ingredientEntity.setQty(ingredient.getQty());
        return ingredientEntity;
    }
}
