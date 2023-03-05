package com.example.foodcost.controller;

import com.example.foodcost.controller.model.RecipeView;
import com.example.foodcost.service.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RecipeApi {

    @PostMapping("/")
    void saveRecipe(@RequestBody RecipeView recipe);

    @GetMapping("/")
    ResponseEntity<List<RecipeView>> getAll();
}
