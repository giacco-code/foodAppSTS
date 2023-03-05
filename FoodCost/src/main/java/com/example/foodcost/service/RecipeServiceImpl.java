package com.example.foodcost.service;

import com.example.foodcost.db.DbRecipe;
import com.example.foodcost.service.model.Recipe;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //todo better do it using a configuration class that initialize the beans
@Data
public class RecipeServiceImpl implements RecipeService {
    private final DbRecipe dbRecipe;

    private final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);

    @Override
    public void save(Recipe recipe) {
        try {
            dbRecipe.save(recipe);
        } catch (Exception exception) {
            logger.error("Could not save recipe. Error: '{}'", exception.getMessage());
        }
    }

    @Override
    public List<Recipe> get() {
        try {
            return dbRecipe.findAll();
        } catch (Exception exception) {
            logger.error("Could not save recipe. Error: '{}'", exception.getMessage());
            throw new RuntimeException("Could not save recipe.");
        }
    }
}
