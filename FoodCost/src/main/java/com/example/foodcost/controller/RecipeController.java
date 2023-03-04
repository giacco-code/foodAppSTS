package com.example.foodcost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.foodcost.service.RecipeService;
@Controller
public class RecipeController {

	@Autowired RecipeService recipeService;
	
	@RequestMapping(method = RequestMethod.POST)
		public void recipeNameSet(String recipeName) {
			recipeService.recipeName(recipeName);
	}
}
