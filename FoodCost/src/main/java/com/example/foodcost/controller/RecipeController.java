package com.example.foodcost.controller;

import com.example.foodcost.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1") // all api declared here will be with a /v1.... ex. /v1/{recipeName}
public class RecipeController {

    private final RecipeService recipeService;

    @RequestMapping(method = RequestMethod.POST, path = "/{recipeName}")
    public void recipeNameSet(@PathVariable String recipeName) {
        recipeService.recipeName(recipeName);
    }
}
