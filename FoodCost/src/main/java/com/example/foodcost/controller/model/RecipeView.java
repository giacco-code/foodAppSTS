package com.example.foodcost.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeView {
    private String name;

    @Singular
    private List<IngredientView> ingredients = new ArrayList<>();
}
